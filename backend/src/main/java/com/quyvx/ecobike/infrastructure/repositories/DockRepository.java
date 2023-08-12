package com.quyvx.ecobike.infrastructure.repositories;

import com.quyvx.ecobike.domain.aggregate_models.Dock;
import com.quyvx.ecobike.domain.repositories.IDockRepository;
import com.quyvx.ecobike.infrastructure.entities.DockEntity;
import com.quyvx.ecobike.infrastructure.entity_mapper.DockEntityMapper;
import com.quyvx.ecobike.infrastructure.jpa_repositories.DockJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DockRepository implements IDockRepository {
    private final DockJpaRepository dockJpaRepository;
    private final DockEntityMapper mapper;
    @Override
    public Dock save(Dock model) {
        DockEntity dockEntity = mapper.modelToEntity(model);
        dockEntity = dockJpaRepository.saveAndFlush(dockEntity);
        return mapper.entityToModel(dockEntity);
    }

    @Override
    public void delete(Long id) {
        dockJpaRepository.deleteById(id);
    }

    @Override
    public Optional<Dock> findById(Long id) {
        return dockJpaRepository.findById(id).map(mapper::entityToModel);
    }

    @Override
    public List<Dock> findAll() {
        return dockJpaRepository.findAll().stream()
                .map(mapper::entityToModel)
                .toList();
    }
}
