package com.quyvx.ecobike.api.dto.card;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProcessTransactionReqDto {
    private String version;
    private TransactionDto transaction;
    private String appCode;
    private String hashCode;
}
