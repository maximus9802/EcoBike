package com.thanhbv.interbank.dto;

import lombok.Getter;

@Getter
public class ResetBalanceReqDto {
    private String cardCode;
    private String owner;
    private String cvvCode;
    private String dateExpired;
}
