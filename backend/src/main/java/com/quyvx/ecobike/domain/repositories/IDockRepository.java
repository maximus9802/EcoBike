package com.quyvx.ecobike.domain.repositories;

import com.quyvx.ecobike.domain.aggregate_models.Dock;

import java.util.List;
import java.util.Optional;

public interface IDockRepository {
    Dock save(Dock model);

    void delete(Long id);

    Optional<Dock> findById(Long id);

    List<Dock> findAll();
}
