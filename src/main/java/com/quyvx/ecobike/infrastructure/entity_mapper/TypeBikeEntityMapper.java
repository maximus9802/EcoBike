package com.quyvx.ecobike.infrastructure.entity_mapper;

import com.quyvx.ecobike.domain.aggregate_models.TypeBike;
import com.quyvx.ecobike.infrastructure.entities.TypeBikeEntity;
import org.springframework.stereotype.Service;

@Service
public class TypeBikeEntityMapper {
    public TypeBikeEntity modelToEntity(TypeBike model){
        return  TypeBikeEntity.builder()
                .id(model.getId())
                .typeName(model.getTypeName())
                .build();
    }

    public TypeBike entityToModel(TypeBikeEntity entity){
        return TypeBike.builder()
                .id(entity.getId())
                .typeName(entity.getTypeName())
                .build();
    }
}
