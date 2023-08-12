package com.quyvx.ecobike.api.controller;

import an.awesome.pipelinr.Pipeline;
import com.quyvx.ecobike.api.application.commands.dock.create.CreateDockCommand;
import com.quyvx.ecobike.api.application.queries.dock.DockQueries;
import com.quyvx.ecobike.api.dto.dock.CreateDockReqDto;
import com.quyvx.ecobike.api.dto.dock.CreateDockResDto;
import com.quyvx.ecobike.domain.aggregate_models.Dock;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@AllArgsConstructor
@RequestMapping("/api/docks")
@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class DockController {
    private final Pipeline pipeline;
    private final DockQueries dockQueries;
    @PostMapping("")
    public CreateDockResDto createDock(@RequestBody CreateDockReqDto request){
        CreateDockCommand command = CreateDockCommand.builder()
                .location(request.getLocation())
                .description(request.getDescription())
                .name(request.getName())
                .build();
        Dock savedDock = pipeline.send(command);
        return CreateDockResDto.builder().id(savedDock.getId()).build();
    }

    @GetMapping("")
    public List<Dock> getAllDocks() {
        return dockQueries.getAllDocks();
    }

    @GetMapping("{dockId}")
    public Dock getDockById(@PathVariable Long dockId) {
        return dockQueries.getDockById(dockId).orElse(null);
    }
}
