package com.quyvx.ecobike.api.application.services;

import com.quyvx.ecobike.api.application.models.tracker.RentInfo;
import com.quyvx.ecobike.api.application.queries.biketracker.IBikeTrackerQueriesService;
import com.quyvx.ecobike.api.application.queries.typetracker.ITypeTrackerQueriesService;
import com.quyvx.ecobike.api.application.queries.typetracker.TypeTrackerQueries;
import com.quyvx.ecobike.api.dto.tracker.AssignTrackerRes;
import com.quyvx.ecobike.domain.aggregate_models.Bike;
import com.quyvx.ecobike.domain.aggregate_models.BikeTracker;
import com.quyvx.ecobike.infrastructure.repositories.BikeTrackerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class TrackerService {
    public static final int STANDARD_BIKE_FACTOR = 1;
    public static final double EBIKE_AND_TWIN_FACTOR = 1.5;
    public static final int INVALID_TYPE_BIKE = -1;
    private final IBikeTrackerQueriesService bikeTrackerQueriesService;
    private final BikeTrackerRepository bikeTrackerRepository;
    private final ITypeTrackerQueriesService typeTrackerQueriesService;
    public RentInfo viewRentInfoToNow(Long bikeId){
        BikeTracker bikeTracker =
                bikeTrackerRepository.findById(bikeTrackerQueriesService.findBikeTrackerByBikeId(bikeId).getId())
                .orElse(null);
        if (bikeTracker != null) {
            long duration = calculateDuration(bikeTracker.getStart(), LocalDateTime.now());
            String typeRent = typeTrackerQueriesService.findTypeNameByTypeId(bikeTracker.getTypeTrackerId());
            return RentInfo.builder()
                    .typeRent(typeRent)
                    .startTime(bikeTracker.getStart())
                    .duration(duration)
                    .cast(calculateCash(duration, typeRent))
                    .build();
        } else return null;
    }

    private long calculateDuration(LocalDateTime start, LocalDateTime end){
        return Duration.between(start, end).toMinutes();
    }

    private long calculateCash(long duration, String typeRent) {
        long cash = 0L;
        if (duration > 10 && duration <= 30) {
            cash += 10000;
        } else if (duration > 30) {
            cash += 10000 + ((duration - 30)/10 + 1) * 3000;
        }
        return Double.valueOf(cash * getFeeFactor(typeRent)).longValue();
    }

    public RentInfo viewRentInfoToNow(Long bikeId){
        Optional<BikeTracker> bikeTracker = bikeTrackerRepository.findById(bikeTrackerQueriesService.findBikeTrackerByBikeId(bikeId));
        RentInfo rentInfo = RentInfo.builder()
                .typeRent(typeTrackerQueriesService.findTypeNameByTypeId(bikeTracker.get().getTypeTrackerId()))
                .startTime(bikeTracker.get().getStart())
                .duration(calculateDuration(bikeTracker.get().getStart(), LocalDateTime.now()))
                .cast(100012L)
                .build();
        return rentInfo;
    }



    public long calculateDuration(LocalDateTime start, LocalDateTime end){
        return Duration.between(start, end).toMinutes();
    }
}
