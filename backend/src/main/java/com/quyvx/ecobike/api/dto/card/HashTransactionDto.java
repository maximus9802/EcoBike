package com.thanhbv.interbank.dto;

import com.quyvx.ecobike.api.dto.card.TransactionDto;
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
