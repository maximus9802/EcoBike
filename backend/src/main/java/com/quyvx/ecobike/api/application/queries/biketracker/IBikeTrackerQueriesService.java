package com.quyvx.ecobike.api.application.queries.biketracker;

import com.quyvx.ecobike.api.application.models.tracker.TrackerDetails;
import com.quyvx.ecobike.domain.aggregate_models.BikeTracker;

import java.util.List;
import java.util.Optional;

public interface IBikeTrackerQueriesService {
    List<TrackerDetails> listTrackerByStatus(String statusTracker);

    Long findBikeTrackerByBikeId(Long id);
}
