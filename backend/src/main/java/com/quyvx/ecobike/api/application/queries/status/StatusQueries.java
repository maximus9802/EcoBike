package com.quyvx.ecobike.api.application.queries.status;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class StatusQueries {
    private final IStatusQueriesService statusQueriesService;

    public Long findStatusIdByStatusName(String statusName){
        return statusQueriesService.finStatusIdByStatusName(statusName);
    }
}
