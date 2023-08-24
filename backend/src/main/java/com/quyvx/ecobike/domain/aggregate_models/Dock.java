package com.quyvx.ecobike.domain.aggregate_models;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
public class Dock {
    private Long id;
    private String location;
    private String description;

    private String linkImage;
    private String name;
    private List<Bike> bikes;
}
