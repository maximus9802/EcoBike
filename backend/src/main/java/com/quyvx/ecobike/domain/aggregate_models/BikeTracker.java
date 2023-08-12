package com.quyvx.ecobike.domain.aggregate_models;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Getter
@Setter
@SuperBuilder
@Slf4j
public class BikeTracker {
    private Long id;

    private LocalDateTime start;

    private LocalDateTime end;

    private Long typeTrackerId;

    private Long bikeId;

    private String status;
}
