package com.quyvx.ecobike.api.dto.bike;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class CreateBikeReqDto {
    private String typeName;
    private String description;
    private BigDecimal price;
    private String linkImage;
    private Long battery;
}
