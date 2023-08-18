package com.thanhbv.interbank.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResetBalanceResDto {
    private int errorCode;
    private String cardCode;
    private String owner;
    private String cvvCode;
    private String dateExpired;
    private long balance;
}
