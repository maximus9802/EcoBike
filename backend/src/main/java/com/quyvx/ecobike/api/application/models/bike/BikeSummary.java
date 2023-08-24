package com.quyvx.ecobike.api.application.models.bike;

import java.math.BigDecimal;

public interface BikeSummary {
    Long getId();
    String getDescription();
    BigDecimal getPrice();
    Long getBattery();
    String getCode();
    String getLinkImage();
    String getLicensePlate();
    String getDeposit();
    String getType();
    String getStatus();
    Long getDock();
    Long getTracker();
}
