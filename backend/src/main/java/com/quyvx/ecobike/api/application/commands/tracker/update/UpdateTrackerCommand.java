package com.quyvx.ecobike.api.application.commands.tracker.update;

import an.awesome.pipelinr.Command;
import com.quyvx.ecobike.domain.aggregate_models.BikeTracker;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class UpdateTrackerCommand implements Command<BikeTracker> {
    private Long id;
    private LocalDateTime start;
    private LocalDateTime end;
    private Long typeTrackerId;
    private Long bikeId;
    private String status;
}
