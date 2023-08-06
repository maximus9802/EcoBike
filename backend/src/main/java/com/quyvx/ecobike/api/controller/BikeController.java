package com.quyvx.ecobike.api.controller;

import an.awesome.pipelinr.Pipeline;
import com.quyvx.ecobike.api.application.commands.bike.create.CreateBikeCommand;
import com.quyvx.ecobike.api.dto.bike.CreateBikeReqDto;
import com.quyvx.ecobike.api.dto.bike.CreateBikeResDto;
import com.quyvx.ecobike.domain.aggregate_models.Bike;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RequestMapping("/api/bikes")
@RestController
public class BikeController {

    private final Pipeline pipeline;

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
}
