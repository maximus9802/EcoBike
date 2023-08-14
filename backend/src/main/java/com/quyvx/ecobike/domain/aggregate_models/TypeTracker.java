package com.quyvx.ecobike.domain.aggregate_models;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Getter
@Setter
@SuperBuilder
@Slf4j
public class TypeTracker {
    public static final long MINUTE_TRACKER_ID = 2L;
    public static final long DAY_TRACKER_ID = 3L;
    private Long id;

    private String name;

    private List<BikeTracker> bikeTrackers;
}
