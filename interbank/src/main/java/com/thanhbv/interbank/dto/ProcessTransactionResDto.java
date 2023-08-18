package com.thanhbv.interbank.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ProcessTransactionResDto {
    private int errorCode;
    private TransactionDto transaction;
}
