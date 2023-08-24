package com.quyvx.ecobike.infrastructure.entity_mapper;

import com.quyvx.ecobike.domain.aggregate_models.Bike;
import com.quyvx.ecobike.domain.aggregate_models.Dock;
import com.quyvx.ecobike.infrastructure.entities.BikeEntity;
import com.quyvx.ecobike.infrastructure.entities.DockEntity;
import com.quyvx.ecobike.infrastructure.jpa_repositories.DockJpaRepository;
import com.quyvx.ecobike.infrastructure.jpa_repositories.StatusJpaRepository;
import com.quyvx.ecobike.infrastructure.jpa_repositories.TypeBikeJpaRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class DockEntityMapper {
    private final StatusJpaRepository statusJpaRepository;
    private final TypeBikeJpaRepository typeBikeJpaRepository;
    private final DockJpaRepository dockJpaRepository;

    public DockEntity modelToEntity(Dock model){
        DockEntity dockEntity = DockEntity.builder()
                .id(model.getId())
                .name(model.getName())
                .description(model.getDescription())
                .linkImage(model.getLinkImage())
                .location(model.getLocation())
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
        dockEntity.setBikes(bikeEntities);
        return dockEntity;
    }

    public Dock entityToModel(DockEntity entity){
        if (ObjectUtils.isEmpty(entity)) {
            return null;
        }

        List<Bike> bikes = new ArrayList<>();
        if(ObjectUtils.isNotEmpty(entity.getBikes())){
            bikes = entity.getBikes().stream()
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
        return Dock.builder()
                .id(entity.getId())
                .location(entity.getLocation())
                .description(entity.getDescription())
                .linkImage(entity.getLinkImage())
                .name(entity.getName())
                .bikes(bikes)
                .build();
    }
}
