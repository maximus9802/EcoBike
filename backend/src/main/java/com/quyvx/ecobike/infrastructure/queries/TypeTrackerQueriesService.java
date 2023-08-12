package com.quyvx.ecobike.infrastructure.queries;

import com.quyvx.ecobike.api.application.queries.typetracker.ITypeTrackerQueriesService;
import com.quyvx.ecobike.infrastructure.jpa_repositories.TypeTrackerJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TypeTrackerQueriesService implements ITypeTrackerQueriesService {
    private final TypeTrackerJpaRepository typeTrackerJpaRepository;
    @Override
    public Long findTypeIdByTypeName(String typeName) {
        return typeTrackerJpaRepository.findTypeIdByTypeName(typeName);
    }

    @Override
    public String findTypeNameByTypeId(Long id) {
        return typeTrackerJpaRepository.findTypeNameByTypeId(id);
    }
}
