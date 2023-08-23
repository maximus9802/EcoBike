package com.quyvx.ecobike.infrastructure.queries;

import com.quyvx.ecobike.api.application.models.dock.DockSummary;
import com.quyvx.ecobike.api.application.queries.dock.IDockQueriesService;
import com.quyvx.ecobike.infrastructure.jpa_repositories.DockJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DockQueriesService implements IDockQueriesService {
    private final DockJpaRepository dockJpaRepository;

    @Override
    public Optional<DockSummary> findDockByDockId(Long dockId) {
        return dockJpaRepository.findDockByDockId(dockId);
    }

    @Override
    public List<DockSummary> getAllDock() {
        return dockJpaRepository.getAllDock();
    }
}
