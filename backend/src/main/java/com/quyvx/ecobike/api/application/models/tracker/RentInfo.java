package com.quyvx.ecobike.api.application.models.tracker;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class RentInfo {
    private LocalDateTime startTime;

    private Long duration;

    private String typeRent;

    private Long cash;
}
