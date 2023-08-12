package com.quyvx.ecobike.domain.aggregate_models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Getter
@Setter
@SuperBuilder
@Slf4j
public class Bike {

    private Long id;

    private String description;

    private BigDecimal price;

    private String linkImage;

    private Long battery;

    private String code;

    private Long statusId;

    private Long typeId;

    private Long dockId;

    private String licensePlate;

    private BigDecimal deposit;

}
