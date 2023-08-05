package com.quyvx.ecobike.domain.repositories;

import com.quyvx.ecobike.domain.aggregate_models.TypeBike;

import java.util.Optional;

public interface ITypeBikeRepository {
    TypeBike save(TypeBike model);

    void delete(Long id);

    Optional<TypeBike> findById(Long id);
}
