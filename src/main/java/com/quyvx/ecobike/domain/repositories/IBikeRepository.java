package com.quyvx.ecobike.domain.repositories;

import com.quyvx.ecobike.domain.aggregate_models.Bike;

import java.util.Optional;

public interface IBikeRepository {
    Bike save(Bike model);

    void delete(Long id);

    Optional<Bike> findById(Long id);
}
