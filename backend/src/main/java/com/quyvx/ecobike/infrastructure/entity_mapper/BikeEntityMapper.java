package com.quyvx.ecobike.infrastructure.entity_mapper;

import com.quyvx.ecobike.domain.aggregate_models.Bike;
import com.quyvx.ecobike.infrastructure.entities.BikeEntity;
import com.quyvx.ecobike.infrastructure.entities.DockEntity;
import com.quyvx.ecobike.infrastructure.entities.StatusBikeEnitity;
import com.quyvx.ecobike.infrastructure.entities.TypeBikeEntity;
import com.quyvx.ecobike.infrastructure.jpa_repositories.DockJpaRepository;
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
    private final DockJpaRepository dockJpaRepository;
    public BikeEntity modelToEntity(Bike model) {
        BikeEntity bikeEntity = new BikeEntity();
        if(model.getCode() != null ){
            bikeEntity = BikeEntity.builder()
                    .id(model.getId())
                    .battery(model.getBattery())
                    .linkImage(model.getLinkImage())
                    .description(model.getDescription())
                    .code(UUID.fromString(model.getCode()))
                    .price(model.getPrice())
                    .licensePlate(model.getLicensePlate())
                    .deposit(model.getDeposit())
                    .build();
        } else {
            bikeEntity = BikeEntity.builder()
                    .id(model.getId())
                    .battery(model.getBattery())
                    .linkImage(model.getLinkImage())
                    .description(model.getDescription())
                    .price(model.getPrice())
                    .licensePlate(model.getLicensePlate())
                    .deposit(model.getDeposit())
                    .build();
        }

        Optional<TypeBikeEntity> typeBikeEntity = typeBikeJpaRepository.findById(model.getTypeId());
        typeBikeEntity.ifPresent(bikeEntity::setType);
        
        Optional<StatusBikeEnitity> statusBikeEntity = statusJpaRepository.findById(model.getStatusId());
        statusBikeEntity.ifPresent(bikeEntity::setStatus);

        Optional<DockEntity> dockEntity = dockJpaRepository.findById(model.getDockId());
        dockEntity.ifPresent(bikeEntity::setDock);
        return bikeEntity;
    }

    public Bike entityToModel(BikeEntity entity){
        return Bike.builder()
                .id(entity.getId())
                .typeId(entity.getType().getId())
                .statusId(entity.getStatus().getId())
                .dockId(entity.getDock().getId())
                .price(entity.getPrice())
                .battery(entity.getBattery())
                .licensePlate(entity.getLicensePlate())
                .deposit(entity.getDeposit())
                .code(entity.getCode().toString())
                .linkImage(entity.getLinkImage())
                .description(entity.getDescription())
                .build();
    }
}
