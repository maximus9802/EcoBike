package com.quyvx.ecobike.api.application.queries.dock;

import com.quyvx.ecobike.api.application.models.dock.DockInfo;
import com.quyvx.ecobike.api.application.models.dock.DockSummary;
import com.quyvx.ecobike.api.application.queries.bike.IBikeQueriesService;
import com.quyvx.ecobike.domain.aggregate_models.Dock;
import com.quyvx.ecobike.infrastructure.repositories.DockRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class DockQueries {
    private final DockRepository dockRepository;
    private final IDockQueriesService dockQueriesService;
    private final IBikeQueriesService bikeQueriesService;

    public List<Dock> getAllDocks() {
        return dockRepository.findAll();
    }

    public Optional<Dock> getDockById(long id) {
        return dockRepository.findById(id);
    }

    public List<DockInfo> getAllDock(){
        List<DockSummary> list = dockQueriesService.getAllDock();
        List<DockInfo> newlist = new ArrayList<>();
        for (DockSummary dockSummary: list) {
            DockInfo dockInfo = DockInfo.builder()
                    .id(dockSummary.getId())
                    .description(dockSummary.getDescription())
                    .name(dockSummary.getName())
                    .location(dockSummary.getLocation())
                    .numberBikeAvailable(bikeQueriesService.countBikeAvailable(dockSummary.getId()))
                    .build();
            newlist.add(dockInfo);
        }
        return newlist;
    }

}
