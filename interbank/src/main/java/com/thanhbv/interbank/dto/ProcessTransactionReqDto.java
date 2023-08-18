package com.thanhbv.interbank.dto;

import lombok.Getter;

@Getter
public class ProcessTransactionReqDto {
    private String version;
    private TransactionDto transaction;
    private String appCode;
    private String hashCode;
}
