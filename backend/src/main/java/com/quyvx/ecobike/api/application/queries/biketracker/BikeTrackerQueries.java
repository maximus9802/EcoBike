package com.quyvx.ecobike.api.application.queries.biketracker;

import com.quyvx.ecobike.domain.aggregate_models.BikeTracker;
import com.quyvx.ecobike.infrastructure.repositories.BikeTrackerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BikeTrackerQueries {
    private final BikeTrackerRepository bikeTrackerRepository;

    public BikeTracker getBikeTrackerByBikeId(long id) {
        return bikeTrackerRepository.findByBikeId(id);
    }
}
