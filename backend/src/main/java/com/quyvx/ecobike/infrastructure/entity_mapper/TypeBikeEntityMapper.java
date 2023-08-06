package com.quyvx.ecobike.infrastructure.entity_mapper;

import com.quyvx.ecobike.domain.aggregate_models.Bike;
import com.quyvx.ecobike.domain.aggregate_models.TypeBike;
import com.quyvx.ecobike.infrastructure.entities.BikeEntity;
import com.quyvx.ecobike.infrastructure.entities.TypeBikeEntity;
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
public class TypeBikeEntityMapper {
    private final StatusJpaRepository statusJpaRepository;
    private final TypeBikeJpaRepository typeBikeJpaRepository;
    private final DockJpaRepository dockJpaRepository;

    public TypeBikeEntity modelToEntity(TypeBike model){
        TypeBikeEntity typeBikeEntity =  TypeBikeEntity.builder()
                .id(model.getId())
                .typeName(model.getTypeName())
                .build();
        List<BikeEntity> bikeEntities = new ArrayList<>();
        if(ObjectUtils.isNotEmpty(model.getBikes())) {
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
        typeBikeEntity.setBikeEntities(bikeEntities);
        return typeBikeEntity;
    }

    public TypeBike entityToModel(TypeBikeEntity entity){
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

        return TypeBike.builder()
                .id(entity.getId())
                .typeName(entity.getTypeName())
                .bikes(bikes)
                .build();
    }
}
