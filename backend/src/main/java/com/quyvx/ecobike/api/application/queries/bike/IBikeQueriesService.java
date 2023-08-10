package com.quyvx.ecobike.api.application.queries.bike;

import com.quyvx.ecobike.api.application.models.bike.BikeDetails;
import com.quyvx.ecobike.infrastructure.entities.BikeEntity;

import java.util.Optional;

public interface IBikeQueriesService {
    Optional<BikeEntity> findById(Long id);
    String findStatusBikeByLongId(Long id);

    Optional<BikeDetails> findBikeWithoutTracker(Long id);
}
