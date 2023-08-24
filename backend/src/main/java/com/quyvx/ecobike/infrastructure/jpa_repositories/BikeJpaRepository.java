package com.quyvx.ecobike.infrastructure.jpa_repositories;

import com.quyvx.ecobike.api.application.models.bike.BikeDetails;
import com.quyvx.ecobike.api.application.models.bike.BikeInfo;
import com.quyvx.ecobike.api.application.models.bike.BikeSummary;
import com.quyvx.ecobike.infrastructure.entities.BikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BikeJpaRepository extends JpaRepository<BikeEntity, Long>, JpaSpecificationExecutor<BikeEntity> {
    @Query(value = "SELECT sb.status_name " +
            "FROM bike b " +
            "LEFT JOIN status_bike as sb ON b.status_id = sb.id " +
            "WHERE b.id = :id", nativeQuery = true)
    String findStatusBikeById(@Param("id") Long id);

    @Query(value = "SELECT b.id as id, b.battery as battery, b.description as description, b.link_image as linkImage, "+
            "b.price as price, tb.type_name as type, b.code as code, b.license_plate as licensePlate, b.deposit as deposit, b.dock_id as dockId " +
            "FROM bike as b " +
            "LEFT JOIN type_bike as tb ON b.type_id = tb.id " +
            "WHERE b.id = :id", nativeQuery = true)
    Optional<BikeDetails> findByWithoutTracker(@Param("id") Long id);

    List<BikeEntity> findAll();

    @Query(value = "SELECT COUNT(*) " +
            "FROM bike as b " +
            "LEFT JOIN status_bike as sb ON b.status_id = sb.id " +
            "WHERE b.dock_id = :dockId AND sb.status_name = 'free' ", nativeQuery = true)
    Integer countBikeAvailableByDockId(@Param("dockId") Long dockId);

//    @Query(value =
//            "SELECT b.id as id, b.description as description, b.price as price, b.battery as battery, b.code as code, b.link_image as linkImage, " +
//            "b.license_plate as licensePlate, b.deposit as deposit, tb.type_name as type, sb.status_name as status, b.dock_id as dock, bt.id as tracker " +
//            "FROM bike as b " +
//            "LEFT JOIN type_bike as tb ON b.type_id = tb.id " +
//            "LEFT JOIN status_bike as sb sb.id = b.status_id " +
//            "JOIN bike_tracker as bt ON bt.bike_id = b.id ", nativeQuery = true)
//    List<BikeSummary> getAllBikeInDock(@Param("dockId") Long dockId);
    @Query(value = "SELECT b.id as id, b.price as price, b.battery as battery, b.code as barCode, b.license_plate as licensePlate, tb.type_name as type, sb.status_name as status " +
            "FROM bike as b " +
            "LEFT JOIN type_bike as tb ON b.type_id = tb.id " +
            "LEFT JOIN status_bike as sb ON b.status_id = sb.id " +
            "WHERE b.dock_id = :dockId AND sb.status_name = 'free' ", nativeQuery = true)
    List<BikeInfo> getBikeInfoInDock(@Param("dockId") Long dockId);

}
