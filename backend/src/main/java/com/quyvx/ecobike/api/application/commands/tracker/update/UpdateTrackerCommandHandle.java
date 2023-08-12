package com.quyvx.ecobike.api.application.commands.tracker.update;

import an.awesome.pipelinr.Command;
import com.quyvx.ecobike.domain.aggregate_models.BikeTracker;
import com.quyvx.ecobike.infrastructure.repositories.BikeTrackerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@AllArgsConstructor
@Component
public class UpdateTrackerCommandHandle implements Command.Handler<UpdateTrackerCommand, BikeTracker> {
    private final BikeTrackerRepository bikeTrackerRepository;
    @Override
    public BikeTracker handle(UpdateTrackerCommand command) {
        BikeTracker bikeTracker = bikeTrackerRepository.findById(command.getId()).orElseThrow(()-> new RuntimeException("Not found tracker"));

        BikeTracker.BikeTrackerBuilder<?,?> bikeTrackerBuilder = BikeTracker.builder()
                .id(command.getId())
                .bikeId(command.getBikeId())
                .typeTrackerId(command.getTypeTrackerId())
                .status(command.getStatus())
                .start(command.getStart())
                .end(command.getEnd());

        BikeTracker savedBikeTracker = bikeTrackerRepository.save(bikeTrackerBuilder.build());
        log.info("----- UpdateTrackerCommand: update tracker {} successfully", savedBikeTracker.getBikeId());
        return savedBikeTracker;
    }
}
