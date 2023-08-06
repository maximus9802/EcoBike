package com.quyvx.ecobike.infrastructure.entity_mapper;

import com.quyvx.ecobike.domain.aggregate_models.BikeTracker;
import com.quyvx.ecobike.infrastructure.entities.BikeEntity;
import com.quyvx.ecobike.infrastructure.entities.BikeTrackerEntity;
import com.quyvx.ecobike.infrastructure.entities.TypeTrackerEntity;
import com.quyvx.ecobike.infrastructure.jpa_repositories.BikeJpaRepository;
import com.quyvx.ecobike.infrastructure.jpa_repositories.TypeTrackerJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class BikeTrackerEntityMapper {
    private final BikeJpaRepository bikeJpaRepository;
    private final TypeTrackerJpaRepository typeTrackerJpaRepository;

    public BikeTrackerEntity modelToEntity(BikeTracker model){
        BikeTrackerEntity entity = BikeTrackerEntity.builder()
                .id(model.getId())
                .start(model.getStart())
                .end(model.getEnd())
                .build();
        Optional<BikeEntity> bikeEntity = bikeJpaRepository.findById(model.getBikeId());
        bikeEntity.ifPresent(entity::setBike);

        Optional<TypeTrackerEntity> typeTrackerEntity = typeTrackerJpaRepository.findById(model.getTypeTrackerId());
        typeTrackerEntity.ifPresent(entity::setTypeTracker);
        return entity;
    }

    public BikeTracker entityToModel(BikeTrackerEntity entity){
        return BikeTracker.builder()
                .id(entity.getId())
                .start(entity.getStart())
                .end(entity.getEnd())
                .bikeId(entity.getBike().getId())
                .typeTrackerId(entity.getTypeTracker().getId())
                .build();
    }
}
