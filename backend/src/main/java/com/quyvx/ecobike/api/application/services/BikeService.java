package com.quyvx.ecobike.api.application.services;

import com.quyvx.ecobike.api.application.queries.bike.BikeQueries;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@RequiredArgsConstructor
@Service
@Slf4j
public class BikeService {
    private final BikeQueries bikeQueries;
    public boolean checkBikeFree(Long id){
        return Objects.equals(bikeQueries.findStatusBikeById(id), "free");
    }
}
