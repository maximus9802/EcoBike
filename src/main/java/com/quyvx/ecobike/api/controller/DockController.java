package com.quyvx.ecobike.api.controller;

import an.awesome.pipelinr.Pipeline;
import com.quyvx.ecobike.api.application.commands.dock.create.CreateDockCommand;
import com.quyvx.ecobike.api.dto.dock.CreateDockReqDto;
import com.quyvx.ecobike.api.dto.dock.CreateDockResDto;
import com.quyvx.ecobike.domain.aggregate_models.Dock;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RequestMapping("/api/docks")
@RestController
public class DockController {
    private final Pipeline pipeline;
    @PostMapping
    public CreateDockResDto createDock(@RequestBody CreateDockReqDto request){
        CreateDockCommand command = CreateDockCommand.builder()
                .location(request.getLocation())
                .description(request.getDescription())
                .name(request.getName())
                .build();
        Dock savedDock = pipeline.send(command);
        return CreateDockResDto.builder().id(savedDock.getId()).build();
    }
}
