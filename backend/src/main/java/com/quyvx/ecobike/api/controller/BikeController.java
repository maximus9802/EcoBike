package com.quyvx.ecobike.api.controller;

import an.awesome.pipelinr.Pipeline;
import com.quyvx.ecobike.api.application.commands.bike.create.CreateBikeCommand;
import com.quyvx.ecobike.api.application.models.bike.BikeDetails;
import com.quyvx.ecobike.api.application.queries.bike.BikeQueries;
import com.quyvx.ecobike.api.application.services.BikeService;
import com.quyvx.ecobike.api.dto.bike.CreateBikeReqDto;
import com.quyvx.ecobike.api.dto.bike.CreateBikeResDto;
import com.quyvx.ecobike.domain.aggregate_models.Bike;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@AllArgsConstructor
@RequestMapping("/api/bikes")
@RestController
public class BikeController {

    private final Pipeline pipeline;
    private final BikeService bikeService;
    private final BikeQueries bikeQueries;

    @PostMapping("")
    public CreateBikeResDto createBike(@RequestBody CreateBikeReqDto request){
        CreateBikeCommand command = CreateBikeCommand.builder()
                .typeName(request.getTypeName())
                .description(request.getDescription())
                .linkImage(request.getLinkImage())
                .price(request.getPrice())
                .battery(request.getBattery())
                .build();
        Bike savedBike = pipeline.send(command);
        return CreateBikeResDto.builder().id(savedBike.getId()).build();
    }

    @GetMapping("{id}")
    public BikeDetails getBikeById(@PathVariable Long id){
        if(bikeService.checkBikeFree(id)) return bikeQueries.getBikeDetailsById(id);
        return null;
    }
}
