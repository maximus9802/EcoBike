package com.quyvx.ecobike.infrastructure.jpa_repositories;

import com.quyvx.ecobike.api.application.models.tracker.TrackerDetails;
import com.quyvx.ecobike.infrastructure.entities.BikeTrackerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BikeTrackerJpaRepository extends JpaRepository<BikeTrackerEntity, Long>, JpaSpecificationExecutor<BikeTrackerEntity> {
    @Query(value = "SELECT bt.id as id, bt.start_time as startTime, bt.end_time as endTime, " +
            "bt.type_tracker_id as typeTrackerId, bt.bike_id as bikeId, bt.status_tracker as statusTracker " +
            "FROM bike_tracker as bt " +
            "WHERE bt.status_tracker = :statusTracker ", nativeQuery = true)
    List<TrackerDetails> listTrackerByStatus(@Param("statusTracker") String statusTracker);
    @Query(value = "SELECT bt.* FROM bike_tracker as bt WHERE bt.bike_id = :bikeId", nativeQuery = true)
    BikeTrackerEntity findTrackerIdByBikeId(@Param("bikeId") Long bikeId);
}
