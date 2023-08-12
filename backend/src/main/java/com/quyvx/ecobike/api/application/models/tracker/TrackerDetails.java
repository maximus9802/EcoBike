package com.quyvx.ecobike.api.application.models.tracker;

import java.time.LocalDateTime;

public interface TrackerDetails {
    Long getId();

    LocalDateTime getStartTime();

    LocalDateTime getEndTime();

    Long getTypeTrackerId();

    Long getBikeId();

    String getStatusTracker();
}
