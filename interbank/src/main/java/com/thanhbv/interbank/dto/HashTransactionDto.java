package com.thanhbv.interbank.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.UUID;

@Builder
@Getter
@EqualsAndHashCode
public class HashTransactionDto {
    private UUID secretKey;
    private TransactionDto transactionDto;

    @Override
    public String toString() {
        return "HashTransactionDto{" +
                "secretKey=" + secretKey.toString() +
                ", transactionDto=" + transactionDto.toString() +
                '}';
    }
}
