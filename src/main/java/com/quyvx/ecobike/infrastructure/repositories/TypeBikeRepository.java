package com.quyvx.ecobike.infrastructure.repositories;

import com.quyvx.ecobike.domain.aggregate_models.TypeBike;
import com.quyvx.ecobike.domain.repositories.ITypeBikeRepository;
import com.quyvx.ecobike.infrastructure.entities.TypeBikeEntity;
import com.quyvx.ecobike.infrastructure.entity_mapper.TypeBikeEntityMapper;
import com.quyvx.ecobike.infrastructure.jpa_repositories.TypeBikeJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class TypeBikeRepository implements ITypeBikeRepository {
    private final TypeBikeJpaRepository typeBikeJpaRepository;
    private final TypeBikeEntityMapper mapper;
    @Override
    public TypeBike save(TypeBike model) {
        TypeBikeEntity typeBikeEntity = mapper.modelToEntity(model);
        typeBikeEntity = typeBikeJpaRepository.saveAndFlush(typeBikeEntity);
        return mapper.entityToModel(typeBikeEntity);
    }

    @Override
    public void delete(Long id) {
        typeBikeJpaRepository.deleteById(id);
    }

    @Override
    public Optional<TypeBike> findById(Long id) {
        return typeBikeJpaRepository.findById(id).map(mapper::entityToModel);
    }
}
