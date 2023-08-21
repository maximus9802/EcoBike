package com.quyvx.ecobike.api.application.models.bike;

import com.quyvx.ecobike.domain.aggregate_models.BikeTracker;

import java.math.BigDecimal;

public interface BikeDetails {
    Long getId();

    Long getBattery();

    String getDescription();

    String getLinkImage();
    String getPrice();
    String getType();
    String getCode();
    String getLicensePlate();
    BigDecimal getDeposit();
    Long getDockId();
    BikeTracker getBikeTracker();
}
