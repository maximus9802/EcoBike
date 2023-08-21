package com.quyvx.ecobike.infrastructure.repositories;

import com.quyvx.ecobike.domain.aggregate_models.BikeTracker;
import com.quyvx.ecobike.domain.repositories.IBikeTrackerRepository;
import com.quyvx.ecobike.infrastructure.entities.BikeTrackerEntity;
import com.quyvx.ecobike.infrastructure.entity_mapper.BikeTrackerEntityMapper;
import com.quyvx.ecobike.infrastructure.jpa_repositories.BikeTrackerJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class BikeTrackerRepository implements IBikeTrackerRepository {
    private final BikeTrackerJpaRepository bikeTrackerJpaRepository;
    private final BikeTrackerEntityMapper mapper;
    @Override
    public BikeTracker save(BikeTracker model) {
        BikeTrackerEntity entity = mapper.modelToEntity(model);
        entity = bikeTrackerJpaRepository.saveAndFlush(entity);
        return mapper.entityToModel(entity);
    }

    @Override
    public void delete(Long id) {
        bikeTrackerJpaRepository.deleteById(id);
    }

    @Override
    public Optional<BikeTracker> findById(Long id) {
        return bikeTrackerJpaRepository.findById(id).map(mapper::entityToModel);
    }

    @Override
    public BikeTracker findByBikeId(long bikeId) {
        BikeTrackerEntity entity = bikeTrackerJpaRepository.findTrackerIdByBikeId(bikeId);
        return mapper.entityToModel(entity);
    }
}
