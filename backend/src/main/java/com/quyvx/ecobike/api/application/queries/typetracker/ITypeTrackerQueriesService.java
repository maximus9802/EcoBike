package com.quyvx.ecobike.api.application.queries.typetracker;

public interface ITypeTrackerQueriesService {
    Long findTypeIdByTypeName(String typeName);

    String findTypeNameByTypeId(Long id);
}
