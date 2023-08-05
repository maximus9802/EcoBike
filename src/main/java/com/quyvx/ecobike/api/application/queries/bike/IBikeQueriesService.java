package com.quyvx.ecobike.api.application.queries.bike;

import com.quyvx.ecobike.infrastructure.entities.BikeEntity;

import java.util.Optional;

public interface IBikeQueriesService {
    Optional<BikeEntity> findById(Long id);
}
