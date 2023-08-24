package com.quyvx.ecobike.api.application.models.dock;

import com.quyvx.ecobike.api.application.models.bike.BikeInfo;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class DockDetails {
    private Long id;
    private String name;
    private String location;
    private String description;
    private List<BikeInfo> bikes;
}
