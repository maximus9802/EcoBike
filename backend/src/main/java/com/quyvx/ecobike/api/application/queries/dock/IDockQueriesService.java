package com.quyvx.ecobike.api.application.queries.dock;

import com.quyvx.ecobike.api.application.models.dock.DockSummary;

import java.util.List;
import java.util.Optional;

public interface IDockQueriesService {
    Optional<DockSummary> findDockByDockId(Long dockId);

    List<DockSummary> getAllDock();
}
