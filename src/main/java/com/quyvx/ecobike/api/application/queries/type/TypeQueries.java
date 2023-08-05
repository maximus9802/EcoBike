package com.quyvx.ecobike.api.application.queries.type;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TypeQueries {
    private final ITypeQueriesService typeQueriesService;

    public Long findTypeIdByTypeName(String typeName){
        return typeQueriesService.findTypeIdByTypeName(typeName);
    }

    public List<String> findAllType(){ return  typeQueriesService.findAllType(); }
}
