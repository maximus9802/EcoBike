package com.quyvx.ecobike.api.application.queries.type;

import java.util.List;

public interface ITypeQueriesService {
    Long findTypeIdByTypeName(String typeName);

    List<String> findAllType();
}
