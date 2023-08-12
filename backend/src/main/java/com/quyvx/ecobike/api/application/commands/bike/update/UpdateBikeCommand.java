package com.quyvx.ecobike.api.application.commands.bike.update;

import an.awesome.pipelinr.Command;
import com.quyvx.ecobike.domain.aggregate_models.Bike;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
public class UpdateBikeCommand implements Command<Bike> {
    private Long id;
    private String description;
    private BigDecimal price;
    private String linkImage;
    private Long battery;
    private String code;
    private Long statusId;
    private Long typeId;
    private Long dockId;
}
