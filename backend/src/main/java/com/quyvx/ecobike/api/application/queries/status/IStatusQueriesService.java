package com.quyvx.ecobike.api.application.queries.status;

public interface IStatusQueriesService {
    Long findStatusIdByStatusName(String statusName);
}
