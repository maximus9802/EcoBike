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
public class TypeBike {
    private Long id;

    private String typeName;

    private List<Bike> bikes;
}
