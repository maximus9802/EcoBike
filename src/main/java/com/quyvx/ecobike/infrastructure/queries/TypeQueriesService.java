package com.quyvx.ecobike.infrastructure.queries;

import com.quyvx.ecobike.api.application.queries.type.ITypeQueriesService;
import com.quyvx.ecobike.infrastructure.jpa_repositories.TypeBikeJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TypeQueriesService implements ITypeQueriesService {

    private final TypeBikeJpaRepository typeBikeJpaRepository;
    @Override
    public Long findTypeIdByTypeName(String typeName) {
        return typeBikeJpaRepository.findTypeIdByTypeName(typeName);
    }

    @Override
    public List<String> findAllType() {
        return typeBikeJpaRepository.findAllType();
    }
}
