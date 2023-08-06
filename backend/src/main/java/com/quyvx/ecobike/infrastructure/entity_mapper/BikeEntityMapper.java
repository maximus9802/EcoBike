package com.quyvx.ecobike.infrastructure.entity_mapper;

import com.quyvx.ecobike.domain.aggregate_models.Bike;
import com.quyvx.ecobike.infrastructure.entities.BikeEntity;
import com.quyvx.ecobike.infrastructure.entities.StatusBikeEnitity;
import com.quyvx.ecobike.infrastructure.entities.TypeBikeEntity;
import com.quyvx.ecobike.infrastructure.jpa_repositories.StatusJpaRepository;
import com.quyvx.ecobike.infrastructure.jpa_repositories.TypeBikeJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class BikeEntityMapper {
    private final TypeBikeJpaRepository typeBikeJpaRepository;
    private final StatusJpaRepository statusJpaRepository;
    public BikeEntity modelToEntity(Bike model) {
        BikeEntity bikeEntity = BikeEntity.builder()
                .id(model.getId())
                .battery(model.getBattery())
                .linkImage(model.getLinkImage())
                .description(model.getDescription())
                .code(UUID.fromString(model.getCode()))
                .price(model.getPrice())
                .build();
        Optional<TypeBikeEntity> typeBikeEntity = typeBikeJpaRepository.findById(model.getTypeId());
        typeBikeEntity.ifPresent(bikeEntity::setType);
        
        Optional<StatusBikeEnitity> statusBikeEntity = statusJpaRepository.findById(model.getStatusId());
        statusBikeEntity.ifPresent(bikeEntity::setStatus);
        return bikeEntity;
    }

    public Bike entityToModel(BikeEntity entity){
        return Bike.builder()
                .id(entity.getId())
                .typeId(entity.getType().getId())
                .statusId(entity.getStatus().getId())
                .price(entity.getPrice())
                .battery(entity.getBattery())
                .code(entity.getCode().toString())
                .linkImage(entity.getLinkImage())
                .description(entity.getDescription())
                .build();
    }
}
