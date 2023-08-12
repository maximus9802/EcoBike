package com.quyvx.ecobike.api.application.services;

import an.awesome.pipelinr.Pipeline;
import com.quyvx.ecobike.api.application.commands.bike.update.UpdateBikeCommand;
import com.quyvx.ecobike.api.application.commands.tracker.update.UpdateTrackerCommand;
import com.quyvx.ecobike.api.application.models.tracker.RentInfo;
import com.quyvx.ecobike.api.application.models.tracker.TrackerDetails;
import com.quyvx.ecobike.api.application.queries.biketracker.IBikeTrackerQueriesService;
import com.quyvx.ecobike.api.application.queries.status.IStatusQueriesService;
import com.quyvx.ecobike.api.application.queries.typetracker.ITypeTrackerQueriesService;
import com.quyvx.ecobike.api.dto.tracker.AssignTrackerRes;
import com.quyvx.ecobike.domain.aggregate_models.Bike;
import com.quyvx.ecobike.domain.aggregate_models.BikeTracker;
import com.quyvx.ecobike.infrastructure.repositories.BikeRepository;
import com.quyvx.ecobike.infrastructure.repositories.BikeTrackerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TrackerService {
    private final IBikeTrackerQueriesService bikeTrackerQueriesService;
    private final BikeTrackerRepository bikeTrackerRepository;
    private final ITypeTrackerQueriesService typeTrackerQueriesService;
    private final IStatusQueriesService statusQueriesService;
    private final BikeRepository bikeRepository;
    private final Pipeline pipeline;
    public AssignTrackerRes assignTracker(String typeTracker, Long id){
        List<TrackerDetails> list = bikeTrackerQueriesService.listTrackerByStatus("free");
        Optional<Bike> bike = bikeRepository.findById(id);
        UpdateBikeCommand bikeCommand = UpdateBikeCommand.builder()
                .id(bike.get().getId())
                .price(bike.get().getPrice())
                .linkImage(bike.get().getLinkImage())
                .description(bike.get().getDescription())
                .code(bike.get().getCode())
                .typeId(bike.get().getTypeId())
                .statusId(statusQueriesService.finStatusIdByStatusName("rented"))
                .dockId(0L)
                .battery(bike.get().getBattery())
                .build();
        if(list.isEmpty()){
            BikeTracker bikeTracker = BikeTracker.builder()
                    .start(LocalDateTime.now())
                    .end(null)
                    .typeTrackerId(typeTrackerQueriesService.findTypeIdByTypeName(typeTracker))
                    .bikeId(id)
                    .status("active")
                    .build();
            bikeTracker = bikeTrackerRepository.save(bikeTracker);
            pipeline.send(bikeCommand);
            log.info("----- TrackerService: assign bike to new tracker successful");
            return AssignTrackerRes.builder()
                    .trackerId(bikeTracker.getId())
                    .build();
        }
        else {
            TrackerDetails trackerDetails = list.get(0);
            UpdateTrackerCommand command = UpdateTrackerCommand.builder()
                    .id(trackerDetails.getId())
                    .start(LocalDateTime.now())
                    .end(null)
                    .typeTrackerId(typeTrackerQueriesService.findTypeIdByTypeName(typeTracker))
                    .bikeId(id)
                    .status("active")
                    .build();
            BikeTracker savedBikeTracker = pipeline.send(command);
            pipeline.send(bikeCommand);
            log.info("----- TrackerService: assign bike to tracker successful");
            return AssignTrackerRes.builder()
                    .trackerId(savedBikeTracker.getId())
                    .build();
        }
    }

    public RentInfo viewRentInfoToNow(Long bikeId){
        BikeTracker bikeTracker = bikeTrackerRepository.findById(bikeTrackerQueriesService.findBikeTrackerByBikeId(bikeId))
                .orElse(null);
        if (bikeTracker != null) {
            return RentInfo.builder()
                    .typeRent(typeTrackerQueriesService.findTypeNameByTypeId(bikeTracker.getTypeTrackerId()))
                    .startTime(bikeTracker.getStart())
                    .duration(calculateDuration(bikeTracker.getStart(), LocalDateTime.now()))
                    .cast(100012L)
                    .build();
        } else return null;
    }

    public long calculateDuration(LocalDateTime start, LocalDateTime end){
        return Duration.between(start, end).toMinutes();
    }
}
