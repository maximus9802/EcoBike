package com.quyvx.ecobike.api.dto.card;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDto {
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
