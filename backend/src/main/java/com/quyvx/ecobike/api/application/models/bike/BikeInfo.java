package com.quyvx.ecobike.api.application.models.bike;

import java.math.BigDecimal;

public interface BikeInfo {
    Long getId();
    BigDecimal getPrice();
    Long getBattery();
    String getBarCode();
    String getLicensePlate();
    String getType();
    String getStatus();
}
