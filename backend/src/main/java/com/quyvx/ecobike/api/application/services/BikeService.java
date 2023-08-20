package com.quyvx.ecobike.api.application.services;

import com.quyvx.ecobike.api.application.queries.bike.BikeQueries;
import com.quyvx.ecobike.domain.aggregate_models.Bike;
import com.quyvx.ecobike.infrastructure.repositories.BikeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@RequiredArgsConstructor
@Service
@Slf4j
public class BikeService {
    private final BikeQueries bikeQueries;

    private final BikeRepository bikeRepository;
    public boolean checkBikeFree(Long id){
        return Objects.equals(bikeQueries.findStatusBikeById(id), "free");
    }

    public boolean checkBikeRented(Long id){
        return Objects.equals(bikeQueries.findStatusBikeById(id), "rented");
    }
    public Bike rentBike(long bikeId) {
        Bike bike = bikeQueries.getBikeById(bikeId);
        bike.setStatusId(Bike.RENTED_STATUS);
        return bikeRepository.save(bike);
    }

    public Bike returnBike(long bikeId) {
        Bike bike = bikeQueries.getBikeById(bikeId);
        bike.setStatusId(Bike.FREE_STATUS);
        return bikeRepository.save(bike);
    }
}
