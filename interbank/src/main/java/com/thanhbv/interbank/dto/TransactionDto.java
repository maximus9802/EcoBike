package com.thanhbv.interbank.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TransactionDto {
    private String transactionId;
    private String cardCode;
    private String owner;
    private String cvvCode;
    private String dateExpired;
    private String command;
    private String transactionContent;
    private long amount;
    private String createdAt;
    @Override
    public String toString() {
        return "TransactionDto{" +
                "cardCode='" + cardCode + '\'' +
                ", owner='" + owner + '\'' +
                ", cvvCode='" + cvvCode + '\'' +
                ", dateExpired='" + dateExpired + '\'' +
                ", command='" + command + '\'' +
                ", transactionContent='" + transactionContent + '\'' +
                ", amount=" + amount +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
