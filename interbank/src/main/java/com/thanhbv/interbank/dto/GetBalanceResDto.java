package com.thanhbv.interbank.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GetBalanceResDto {
    private int errorCode;
    private String cardCode;
    private long balance;
}
