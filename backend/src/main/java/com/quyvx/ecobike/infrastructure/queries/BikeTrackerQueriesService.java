package com.quyvx.ecobike.infrastructure.queries;

import com.quyvx.ecobike.api.application.models.tracker.TrackerDetails;
import com.quyvx.ecobike.api.application.queries.biketracker.IBikeTrackerQueriesService;
import com.quyvx.ecobike.domain.aggregate_models.BikeTracker;
import com.quyvx.ecobike.infrastructure.jpa_repositories.BikeTrackerJpaRepository;
import com.quyvx.ecobike.infrastructure.repositories.BikeTrackerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BikeTrackerQueriesService implements IBikeTrackerQueriesService {
    private final BikeTrackerJpaRepository bikeTrackerJpaRepository;
    private final BikeTrackerRepository bikeTrackerRepository;
    @Override
    public List<TrackerDetails> listTrackerByStatus(String statusTracker) {
        return bikeTrackerJpaRepository.listTrackerByStatus(statusTracker);
    }

    @Override
    public Long findBikeTrackerByBikeId(Long id) {
        return bikeTrackerJpaRepository.findTrackerIdByBikeId(id);
    }
}
