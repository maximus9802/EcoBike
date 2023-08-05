package com.quyvx.ecobike.api.application.commands.dock.create;

import an.awesome.pipelinr.Command;
import com.quyvx.ecobike.domain.aggregate_models.Dock;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CreateDockCommand implements Command<Dock> {
    private String location;
    private String description;
    private String name;
}
