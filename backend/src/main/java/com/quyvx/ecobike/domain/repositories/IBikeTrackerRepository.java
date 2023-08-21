package com.quyvx.ecobike.domain.repositories;

import com.quyvx.ecobike.domain.aggregate_models.BikeTracker;

import java.util.Optional;

public interface IBikeTrackerRepository {
    BikeTracker save(BikeTracker model);

    void delete(Long id);

    Optional<BikeTracker> findById(Long id);

    BikeTracker findByBikeId(long bikeId);
}
