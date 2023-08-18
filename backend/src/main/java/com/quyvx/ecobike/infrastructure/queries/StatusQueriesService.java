package com.quyvx.ecobike.infrastructure.queries;

import com.quyvx.ecobike.api.application.queries.status.IStatusQueriesService;
import com.quyvx.ecobike.infrastructure.jpa_repositories.StatusJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class StatusQueriesService implements IStatusQueriesService {

    private final StatusJpaRepository statusJpaRepository;
    @Override
    public Long findStatusIdByStatusName(String statusName) {
        return statusJpaRepository.findStatusIdByStatusName(statusName);
    }
}
