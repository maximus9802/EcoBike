package com.quyvx.ecobike.api.controller;

import an.awesome.pipelinr.Pipeline;
import com.quyvx.ecobike.api.application.commands.bike.create.CreateBikeCommand;
import com.quyvx.ecobike.api.application.models.TypeTrackerIdRequest;
import com.quyvx.ecobike.api.application.models.bike.BikeDetails;
import com.quyvx.ecobike.api.application.queries.bike.BikeQueries;
import com.quyvx.ecobike.api.application.queries.biketracker.BikeTrackerQueries;
import com.quyvx.ecobike.api.application.services.BikeService;
import com.quyvx.ecobike.api.application.services.TrackerService;
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
@CrossOrigin(origins = {"http://localhost:5173", "http://127.0.0.1:5173"})

public class BikeController {
    private final Pipeline pipeline;
    private final BikeService bikeService;
    private final TrackerService trackerService;
    private final BikeQueries bikeQueries;
    private final BikeTrackerQueries bikeTrackerQueries;

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

    @PutMapping("rent_bike/{bikeId}")
    public BikeTracker rentBike(@PathVariable long bikeId, @RequestBody TypeTrackerIdRequest request) {
        if (bikeService.checkBikeFree(bikeId)){
            bikeService.rentBike(bikeId);
            return trackerService.rentBike(request.getTypeTrackerId(), bikeId);
        }
        else return null;
    }

    @GetMapping("get-bike/{id}")
    public Bike getBikeById(@PathVariable long id) {
        return bikeQueries.getBikeById(id);
    }

    @PutMapping("return_bike/{bikeId}")
    public BikeTracker returnBike(@PathVariable long bikeId) {
        if (bikeService.checkBikeRented(bikeId)){
            bikeService.returnBike(bikeId);
            return trackerService.returnBike(bikeId);
        }
        else return null;
    }
}
