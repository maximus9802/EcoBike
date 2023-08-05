package com.quyvx.ecobike.infrastructure.entity_mapper;

import com.quyvx.ecobike.domain.aggregate_models.StatusBike;
import com.quyvx.ecobike.infrastructure.entities.StatusBikeEnitity;
import org.springframework.stereotype.Service;

@Service
public class StatusEntityMapper {
    public StatusBikeEnitity modelToEntity(StatusBike model){
        return StatusBikeEnitity.builder()
                .id(model.getId())
                .statusName(model.getStatusName())
                .build();
    }

    public StatusBike entityToModel(StatusBikeEnitity entity){
        return StatusBike.builder()
                .id(entity.getId())
                .statusName(entity.getStatusName())
                .build();
    }
}
