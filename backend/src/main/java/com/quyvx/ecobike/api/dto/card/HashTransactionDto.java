package com.quyvx.ecobike.api.dto.card;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.UUID;

@Builder
@Getter
@EqualsAndHashCode
public class HashTransactionDto {
    private String secretKey;
    private TransactionDto transactionDto;

    @Override
    public String toString() {
        return "HashTransactionDto{" +
                "secretKey=" + secretKey +
                ", transactionDto=" + transactionDto.toString() +
                '}';
    }
}
