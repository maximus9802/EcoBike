package com.quyvx.ecobike.infrastructure.entity_mapper;

import com.quyvx.ecobike.domain.aggregate_models.BikeTracker;
import com.quyvx.ecobike.domain.aggregate_models.TypeTracker;
import com.quyvx.ecobike.infrastructure.entities.BikeTrackerEntity;
import com.quyvx.ecobike.infrastructure.entities.TypeTrackerEntity;
import com.quyvx.ecobike.infrastructure.jpa_repositories.BikeJpaRepository;
import com.quyvx.ecobike.infrastructure.jpa_repositories.TypeTrackerJpaRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TypeTrackerEntityMapper {
    private final BikeJpaRepository bikeJpaRepository;
    private final TypeTrackerJpaRepository typeTrackerJpaRepository;
    public TypeTrackerEntity modelToEntity(TypeTracker model){
        TypeTrackerEntity entity = TypeTrackerEntity.builder()
                .id(model.getId())
                .name(model.getName())
                .build();
        List<BikeTrackerEntity> bikes = new ArrayList<>();
        bikes = model.getBikeTrackers().stream()
                .map(bikeTracker -> (BikeTrackerEntity) BikeTrackerEntity.builder()
                        .id(bikeTracker.getId())
                        .startTime(bikeTracker.getStart())
                        .endTime(bikeTracker.getEnd())
                        .typeTracker(typeTrackerJpaRepository.findById(bikeTracker.getTypeTrackerId()).get())
                        .bike(bikeJpaRepository.findById(bikeTracker.getBikeId()).get())
                        .build()).toList();
        entity.setBikeTrackerEntities(bikes);
        return entity;
    }

    public TypeTracker entityToModel(TypeTrackerEntity entity){
        if (ObjectUtils.isEmpty(entity)) {
            return null;
        }

        List<BikeTracker> bikeTrackers = entity.getBikeTrackerEntities().stream()
                .map(bikeTrackerEntity -> (BikeTracker) BikeTracker.builder()
                        .id(bikeTrackerEntity.getId())
                        .start(bikeTrackerEntity.getStartTime())
                        .end(bikeTrackerEntity.getEndTime())
                        .bikeId(bikeTrackerEntity.getBike().getId())
                        .typeTrackerId(bikeTrackerEntity.getTypeTracker().getId())
                        .build()).toList();

        return TypeTracker.builder()
                .id(entity.getId())
                .name(entity.getName())
                .bikeTrackers(bikeTrackers)
                .build();
    }
}
