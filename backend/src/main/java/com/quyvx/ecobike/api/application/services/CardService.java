package com.quyvx.ecobike.api.application.services;

import com.quyvx.ecobike.api.dto.card.HashTransactionDto;
import com.quyvx.ecobike.api.dto.card.ProcessTransactionReqDto;
import com.quyvx.ecobike.api.dto.card.TransactionDto;
import com.quyvx.ecobike.domain.aggregate_models.Card;
import com.quyvx.ecobike.infrastructure.repositories.CardRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.SerializationUtils;

import java.util.Objects;

@Service
@AllArgsConstructor
public class CardService {
    private final CardRepository cardRepository;
    public final static String APP_CODE = "be34767d-87c6-4c85-8967-07b6cf69d578";
    public final static String SECRET_KEY = "b132b970-7161-4c5a-8f63-c55f6ae49169";
    public final static String VERSION = "1.0.1";

    public HttpEntity<ProcessTransactionReqDto> buildRequestDto(TransactionDto transactionDto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String hashCode = getHashCode(transactionDto);
        ProcessTransactionReqDto processTransactionReqDto = ProcessTransactionReqDto.builder()
                .version(VERSION)
                .transaction(transactionDto)
                .hashCode(hashCode)
                .appCode(APP_CODE)
                .build();
        return new HttpEntity<>(processTransactionReqDto, headers);
    }

    private String getHashCode (TransactionDto transactionDto){
        HashTransactionDto hashTransactionDto = HashTransactionDto.builder()
                .secretKey(SECRET_KEY)
                .transactionDto(transactionDto)
                .build();
        return DigestUtils.md5DigestAsHex(Objects.requireNonNull(SerializationUtils.serialize(hashTransactionDto.toString())));
    }

    public Card findByCardCode(String cardCode) {
        return cardRepository.findByCardCode(cardCode).orElse(null);
    }
}
