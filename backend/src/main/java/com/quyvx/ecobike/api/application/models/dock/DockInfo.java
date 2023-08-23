package com.quyvx.ecobike.api.application.models.dock;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DockInfo {
    private Long id;
    private String location;
    private String name;
    private String description;
    private int numberBikeAvailable;
}
