package com.quyvx.ecobike.api.application.services;

import com.quyvx.ecobike.api.dto.card.ProcessTransactionReqDto;
import com.quyvx.ecobike.api.dto.card.TransactionDto;
import com.quyvx.ecobike.domain.aggregate_models.Card;
import com.quyvx.ecobike.infrastructure.repositories.CardRepository;
import com.thanhbv.interbank.dto.HashTransactionDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.SerializationUtils;

import java.util.Objects;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CardService {
    private final CardRepository cardRepository;

    public void processTransaction(ProcessTransactionReqDto processTransactionReqDto) {
        Card card = cardRepository.findByCardCode(processTransactionReqDto.getTransaction().getCardCode()).orElse(null);
        if (card == null) return;
        if (!card.getAppCode().equals(processTransactionReqDto.getAppCode())) {
            return;
        }
    }

    public String getHashCode (TransactionDto transactionDto){
        UUID secretKey = cardRepository.findByCardCode(transactionDto.getCardCode())
                .orElse(null).getSecretToken();
        HashTransactionDto hashTransactionDto = HashTransactionDto.builder()
                .secretKey(secretKey)
                .transactionDto(transactionDto)
                .build();
        return DigestUtils.md5DigestAsHex(Objects.requireNonNull(SerializationUtils.serialize(hashTransactionDto.toString())));
    }

    public Card findByCardCode(String cardCode) {
        return cardRepository.findByCardCode(cardCode).orElse(null);
    }
}
