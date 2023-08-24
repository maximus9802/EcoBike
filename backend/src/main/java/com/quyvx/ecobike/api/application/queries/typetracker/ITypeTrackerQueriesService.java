package com.quyvx.ecobike.api.application.queries.typetracker;

import com.quyvx.ecobike.api.application.models.tracker.TrackerSummary;

import java.util.Optional;

public interface ITypeTrackerQueriesService {
    Long findTypeIdByTypeName(String typeName);

    String findTypeNameByTypeId(Long id);

}
