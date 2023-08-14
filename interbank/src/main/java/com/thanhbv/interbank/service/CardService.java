package com.thanhbv.interbank.service;

import com.thanhbv.interbank.dto.HashTransactionDto;
import com.thanhbv.interbank.dto.ProcessTransactionReqDto;
import com.thanhbv.interbank.dto.ProcessTransactionResDto;
import com.thanhbv.interbank.dto.ResetBalanceReqDto;
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
        UUID appCode = UUID.fromString(processTransactionReqDto.getAppCode());
        UUID secretCode = cardRepository.findBySecretCode(appCode).orElse(null);

        HashTransactionDto hashTransactionDto = HashTransactionDto.builder()
                .secretKey(secretCode)
                .transactionDto(processTransactionReqDto.getTransaction())
                .build();
        if (!isEquals(processTransactionReqDto, hashTransactionDto)) {
            return ProcessTransactionResDto.builder()
                    .errorCode(4)
                    .transaction(processTransactionReqDto.getTransaction())
                    .build();
        }
        String command = processTransactionReqDto.getTransaction().getCommand();
        Card card = cardRepository.findById(processTransactionReqDto.getTransaction().getCardCode()).orElse(null);
        long amount = processTransactionReqDto.getTransaction().getAmount();
        assert card != null;
        if (command.equals(PAY)) {
            if (card.getBalance() >= amount) {
                card.setBalance(card.getBalance() - amount);
                cardRepository.save(card);
            } else return ProcessTransactionResDto.builder()
                    .errorCode(2)
                    .transaction(processTransactionReqDto.getTransaction())
                    .build();
        } else if (command.equals(REFUND)) {
            card.setBalance(card.getBalance() + amount);
            cardRepository.save(card);
        } else {
            return ProcessTransactionResDto.builder()
                    .errorCode(5)
                    .transaction(processTransactionReqDto.getTransaction())
                    .build();
        }
        return ProcessTransactionResDto
                .builder()
                .errorCode(0)
                .transaction(processTransactionReqDto.getTransaction())
                .build();
    }

    private static boolean isEquals(ProcessTransactionReqDto processTransactionReqDto, HashTransactionDto hashTransactionDto) {
        return DigestUtils.md5DigestAsHex(Objects.requireNonNull(SerializationUtils.serialize(hashTransactionDto.toString())))
                .equals(processTransactionReqDto.getHashCode());
    }


}
