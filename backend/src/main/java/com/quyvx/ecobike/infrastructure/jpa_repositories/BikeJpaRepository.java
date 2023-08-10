package com.quyvx.ecobike.infrastructure.jpa_repositories;

import com.quyvx.ecobike.api.application.models.bike.BikeDetails;
import com.quyvx.ecobike.infrastructure.entities.BikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BikeJpaRepository extends JpaRepository<BikeEntity, Long>, JpaSpecificationExecutor<BikeEntity> {
    @Query(value = "SELECT sb.status_name " +
            "FROM bike b " +
            "LEFT JOIN status_bike as sb ON b.status_id = sb.id " +
            "WHERE b.id = :id", nativeQuery = true)
    String findStatusBikeById(@Param("id") Long id);

    @Query(value = "SELECT b.id as id, b.battery as battery, b.description as description, b.link_image as linkImage, "+
            "b.price as price, tb.type_name as type, b.code as code " +
            "FROM bike as b " +
            "LEFT JOIN type_bike as tb ON b.type_id = tb.id " +
            "WHERE b.id = :id", nativeQuery = true)
    Optional<BikeDetails> findByWithoutTracker(@Param("id") Long id);
}
