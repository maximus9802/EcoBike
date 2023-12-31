package com.quyvx.ecobike.api.application.commands.bike.create;

import an.awesome.pipelinr.Command;
import com.quyvx.ecobike.domain.aggregate_models.Bike;
import com.quyvx.ecobike.domain.aggregate_models.BikeTracker;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
public class CreateBikeCommand implements Command<Bike>{
    private String typeName;
    private String description;
    private BigDecimal price;
    private String linkImage;
    private Long battery;
    private String licensePlate;
    private BigDecimal deposit;
    private BikeTracker bikeTracker;
    private Long dockId;
}
