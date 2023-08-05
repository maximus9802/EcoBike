package com.quyvx.ecobike.api.dto.dock;

import lombok.Getter;

@Getter
public class CreateDockReqDto {
    private String location;

    private String description;

    private String name;
}
