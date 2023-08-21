package com.quyvx.ecobike.api.application.queries.biketracker;

import com.quyvx.ecobike.api.application.models.tracker.TrackerDetails;
import com.quyvx.ecobike.domain.aggregate_models.BikeTracker;

import java.util.List;

public interface IBikeTrackerQueriesService {
    List<TrackerDetails> listTrackerByStatus(String statusTracker);

    BikeTracker findBikeTrackerByBikeId(Long id);
}
