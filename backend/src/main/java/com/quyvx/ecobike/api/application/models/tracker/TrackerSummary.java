package com.quyvx.ecobike.api.application.models.tracker;

import java.time.LocalDateTime;

public interface TrackerSummary {
    Long getId();
    LocalDateTime getStartTime();
    LocalDateTime getEndTime();
    String getStatus();
    Long getBikeId();
    String getTypeTracker();
}
