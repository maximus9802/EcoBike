package com.quyvx.ecobike.infrastructure.queries;

import com.quyvx.ecobike.api.application.models.tracker.TrackerDetails;
import com.quyvx.ecobike.api.application.models.tracker.TrackerSummary;
import com.quyvx.ecobike.api.application.queries.biketracker.IBikeTrackerQueriesService;
import com.quyvx.ecobike.domain.aggregate_models.BikeTracker;
import com.quyvx.ecobike.infrastructure.entities.BikeTrackerEntity;
import com.quyvx.ecobike.infrastructure.entity_mapper.BikeTrackerEntityMapper;
import com.quyvx.ecobike.infrastructure.jpa_repositories.BikeTrackerJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BikeTrackerQueriesService implements IBikeTrackerQueriesService {
    private final BikeTrackerJpaRepository bikeTrackerJpaRepository;
    private final BikeTrackerEntityMapper mapper;
    @Override
    public List<TrackerDetails> listTrackerByStatus(String statusTracker) {
        return bikeTrackerJpaRepository.listTrackerByStatus(statusTracker);
    }

    @Override
    public BikeTracker findBikeTrackerByBikeId(Long id) {
        BikeTrackerEntity entity = bikeTrackerJpaRepository.findTrackerIdByBikeId(id);
        return mapper.entityToModel(entity);
    }

    @Override
    public Optional<TrackerSummary> getTrackerSummaryByBikeId(Long bikeId) {
        return bikeTrackerJpaRepository.getTrackerSummaryByBikeId(bikeId);
    }
}
