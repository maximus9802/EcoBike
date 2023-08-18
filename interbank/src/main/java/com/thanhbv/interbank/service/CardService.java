package com.thanhbv.interbank.service;

import com.thanhbv.interbank.dto.*;
import com.thanhbv.interbank.model.Card;
import com.thanhbv.interbank.repository.CardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.SerializationUtils;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CardService {
    public static final String PAY = "pay";
    public static final String REFUND = "refund";

    private final CardRepository cardRepository;

    public Optional<Card> getCardByCardCode(String cardCode) {
        return cardRepository.findById(cardCode);
    }

    public Card resetBalance(ResetBalanceReqDto resetBalanceReqDto) {
        Card card = cardRepository.findById(resetBalanceReqDto.getCardCode()).orElse(null);
        if (card != null) {
            card.setBalance(1000000L);
            cardRepository.save(card);
        }
        return card;
    }

    public ProcessTransactionResDto processTransaction(ProcessTransactionReqDto processTransactionReqDto) {
        Optional<Card> card = cardRepository.findById(processTransactionReqDto.getTransaction().getCardCode());
        if (card.isEmpty()) {
            return validCard(processTransactionReqDto);
        }
        HashTransactionDto hashTransactionDto = HashTransactionDto.builder()
                .secretKey(Code.SECRET_KEY)
                .transactionDto(processTransactionReqDto.getTransaction())
                .build();

        processTransactionReqDto.getTransaction().setTransactionId(UUID.randomUUID().toString());
        TransactionDto transactionDto = processTransactionReqDto.getTransaction();
        if (!Objects.equals(processTransactionReqDto.getAppCode(), Code.APP_CODE) || !isEquals(processTransactionReqDto,
                hashTransactionDto)) {
            return ProcessTransactionResDto.builder()
                    .errorCode(ErrorCode.SUSPECTED_FRAUD)
                    .transaction(transactionDto)
                    .build();
        }
        String command = transactionDto.getCommand();
        long amount = transactionDto.getAmount();
        Card validCard = card.get();
        if (command.equals(PAY)) {
            if (validCard.getBalance() >= amount) {
                validCard.setBalance(validCard.getBalance() - amount);
                cardRepository.save(validCard);
            } else return ProcessTransactionResDto.builder()
                    .errorCode(ErrorCode.NOT_ENOUGH_AMOUNT)
                    .transaction(transactionDto)
                    .build();
        } else if (command.equals(REFUND)) {
            validCard.setBalance(validCard.getBalance() + amount);
            cardRepository.save(validCard);
        } else {
            return ProcessTransactionResDto.builder()
                    .errorCode(ErrorCode.MISSING_DATA)
                    .transaction(transactionDto)
                    .build();
        }
        return ProcessTransactionResDto
                .builder()
                .errorCode(ErrorCode.SUCCESS_CODE)
                .transaction(transactionDto)
                .build();
    }

    private static ProcessTransactionResDto validCard(ProcessTransactionReqDto processTransactionReqDto) {
        return ProcessTransactionResDto.builder()
                .errorCode(ErrorCode.INVALID_CARD)
                .transaction(processTransactionReqDto.getTransaction())
                .build();
    }

    private static boolean isEquals(ProcessTransactionReqDto processTransactionReqDto, HashTransactionDto hashTransactionDto) {
        return DigestUtils.md5DigestAsHex(Objects.requireNonNull(SerializationUtils.serialize(hashTransactionDto.toString())))
                .equals(processTransactionReqDto.getHashCode());
    }
}
