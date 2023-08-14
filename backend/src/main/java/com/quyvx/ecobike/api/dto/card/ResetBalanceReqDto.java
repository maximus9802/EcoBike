package com.quyvx.ecobike.api.dto.card;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ResetBalanceReqDto {
    private String cardCode;
    private String owner;
    private String cvvCode;
    private String dateExpired;
}
