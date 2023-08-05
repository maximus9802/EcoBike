package com.quyvx.ecobike.infrastructure.repositories;

import com.quyvx.ecobike.domain.aggregate_models.Bike;
import com.quyvx.ecobike.domain.repositories.IBikeRepository;
import com.quyvx.ecobike.infrastructure.entities.BikeEntity;
import com.quyvx.ecobike.infrastructure.entity_mapper.BikeEntityMapper;
import com.quyvx.ecobike.infrastructure.jpa_repositories.BikeJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class BikeRepository implements IBikeRepository {
    private final BikeJpaRepository bikeJpaRepository;
    private final BikeEntityMapper mapper;

    @Override
    public Bike save(Bike model) {
        BikeEntity bikeEntity = mapper.modelToEntity(model);
        bikeEntity = bikeJpaRepository.saveAndFlush(bikeEntity);
        return mapper.entityToModel(bikeEntity);
    }

    @Override
    public void delete(Long id) {
        bikeJpaRepository.deleteById(id);
    }

    @Override
    public Optional<Bike> findById(Long id) {
        return bikeJpaRepository.findById(id).map(mapper::entityToModel);
    }
}
