package com.quyvx.ecobike.api.controller;

import an.awesome.pipelinr.Pipeline;
import com.quyvx.ecobike.api.application.commands.bike.create.CreateBikeCommand;
import com.quyvx.ecobike.api.application.models.bike.BikeDetails;
import com.quyvx.ecobike.api.application.queries.bike.BikeQueries;
import com.quyvx.ecobike.api.application.services.BikeService;
import com.quyvx.ecobike.api.dto.bike.CreateBikeReqDto;
import com.quyvx.ecobike.api.dto.bike.CreateBikeResDto;
import com.quyvx.ecobike.domain.aggregate_models.Bike;
import com.quyvx.ecobike.domain.aggregate_models.BikeTracker;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

import static com.quyvx.ecobike.domain.aggregate_models.TypeTracker.MINUTE_TRACKER_ID;

@Slf4j
@AllArgsConstructor
@RequestMapping("/api/bikes")
@RestController
@CrossOrigin(origins = "http://127.0.0.1:5173")
public class BikeController {
    private final Pipeline pipeline;
    private final BikeService bikeService;
    private final BikeQueries bikeQueries;

    @PostMapping("")
    public CreateBikeResDto createBike(@RequestBody CreateBikeReqDto request){

        CreateBikeCommand command = CreateBikeCommand.builder()
                .typeName(request.getTypeName())
                .linkImage(request.getLinkImage())
                .price(request.getPrice())
                .licensePlate(request.getLicensePlate())
                .deposit(request.getDeposit())
                .description(request.getDescription())
                .battery(request.getBattery())
                .build();
        Bike savedBike = pipeline.send(command);
        long id = savedBike.getId();
        BikeTracker bikeTracker = BikeTracker.builder()
                .bikeId(id)
                .start(LocalDateTime.now())
                .end(LocalDateTime.now())
                .typeTrackerId(MINUTE_TRACKER_ID)
                .status("stop")
                .build();
        savedBike.setBikeTracker(bikeTracker);
        return CreateBikeResDto.builder().id(savedBike.getId()).build();
    }

    @GetMapping("{id}")
    public BikeDetails getBikeById(@PathVariable Long id){
        if(bikeService.checkBikeFree(id)) return bikeQueries.getBikeDetailsById(id);
        return null;
    }

    @GetMapping("")
    public List<BikeDetails> getAllBike() {
        return bikeQueries.getAllBikeDetails();
    }

    @PutMapping("rent_bike/{id}")
    public BikeDetails rentBike(@PathVariable long id, @RequestBody long typeTrackerId) {
        BikeDetails bike =  bikeQueries.getBikeDetailsById(id);
        bike.getBikeTracker().setStatus("active");
        bike.getBikeTracker().setTypeTrackerId(typeTrackerId);
        bike.getBikeTracker().setStart(LocalDateTime.now());
        return bike;
    }


}
