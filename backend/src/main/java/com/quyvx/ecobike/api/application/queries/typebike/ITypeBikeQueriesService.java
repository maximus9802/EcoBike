package com.quyvx.ecobike.api.application.queries.typebike;

import java.util.List;

public interface ITypeBikeQueriesService {
    Long findTypeIdByTypeName(String typeName);

    List<String> findAllType();
}
