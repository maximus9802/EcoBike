package com.quyvx.ecobike.api.application.queries.bike;

import com.quyvx.ecobike.api.application.models.bike.BikeDetails;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class BikeQueries {
    private final IBikeQueriesService bikeQueriesService;

    public String findStatusBikeById(Long id){
        return bikeQueriesService.findStatusBikeByLongId(id);
    }

    public BikeDetails getBikeDetailsById(Long id){
        return bikeQueriesService.findBikeWithoutTracker(id).orElseThrow(() -> new RuntimeException("bike not found"));
    }

    public List<BikeDetails> getAllBikeDetails() {
        return bikeQueriesService.getAllBikeDetails();
    }

}
