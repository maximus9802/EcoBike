package com.quyvx.ecobike.api.application.models.rent;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Builder
public class RentDetail {
    private LocalDateTime startTime;
    private BigDecimal cash;
    private String status;
    private Long timeRented;
}
