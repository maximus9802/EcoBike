package com.quyvx.ecobike.infrastructure.entity_mapper;

import com.quyvx.ecobike.domain.aggregate_models.Bike;
import com.quyvx.ecobike.domain.aggregate_models.StatusBike;
import com.quyvx.ecobike.infrastructure.entities.BikeEntity;
import com.quyvx.ecobike.infrastructure.entities.StatusBikeEnitity;
import com.quyvx.ecobike.infrastructure.jpa_repositories.DockJpaRepository;
import com.quyvx.ecobike.infrastructure.jpa_repositories.StatusJpaRepository;
import com.quyvx.ecobike.infrastructure.jpa_repositories.TypeBikeJpaRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class StatusEntityMapper {
    private final StatusJpaRepository statusJpaRepository;
    private final TypeBikeJpaRepository typeBikeJpaRepository;
    private final DockJpaRepository dockJpaRepository;

    public StatusBikeEnitity modelToEntity(StatusBike model){
        StatusBikeEnitity statusBikeEnitity = StatusBikeEnitity.builder()
                .id(model.getId())
                .statusName(model.getStatusName())
                .build();
        List<BikeEntity> bikeEntities = new ArrayList<>();
        if(ObjectUtils.isNotEmpty(model.getBikes())){
            bikeEntities = model.getBikes().stream()
                    .map(bike -> (BikeEntity) BikeEntity.builder()
                            .id(bike.getId())
                            .price(bike.getPrice())
                            .battery(bike.getBattery())
                            .description(bike.getDescription())
                            .linkImage(bike.getLinkImage())
                            .status(statusJpaRepository.findById(bike.getStatusId()).get())
                            .type(typeBikeJpaRepository.findById(bike.getTypeId()).get())
                            .dock(dockJpaRepository.findById(bike.getDockId()).get())
                            .build())
                    .toList();
        }
        statusBikeEnitity.setBikeEntities(bikeEntities);

        return statusBikeEnitity;
    }

    public StatusBike entityToModel(StatusBikeEnitity entity){
        if (ObjectUtils.isEmpty(entity)) {
            return null;
        }

        List<Bike> bikes = new ArrayList<>();
        if(ObjectUtils.isNotEmpty(entity.getBikeEntities())){
            bikes = entity.getBikeEntities().stream()
                    .map(bikeEntity -> (Bike) Bike.builder()
                            .id(bikeEntity.getId())
                            .battery(bikeEntity.getBattery())
                            .price(bikeEntity.getPrice())
                            .linkImage(bikeEntity.getLinkImage())
                            .description(bikeEntity.getDescription())
                            .statusId(bikeEntity.getStatus().getId())
                            .dockId(bikeEntity.getDock().getId())
                            .typeId(bikeEntity.getType().getId())
                            .build())
                    .toList();
        }
        return StatusBike.builder()
                .id(entity.getId())
                .statusName(entity.getStatusName())
                .bikes(bikes)
                .build();
    }
}
