package com.quyvx.ecobike.infrastructure.jpa_repositories;

import com.quyvx.ecobike.api.application.models.dock.DockSummary;
import com.quyvx.ecobike.infrastructure.entities.DockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DockJpaRepository extends JpaRepository<DockEntity, Long>, JpaSpecificationExecutor<DockEntity> {
    @Query(value =
            "SELECT d.id as id, d.name as name, d.location as location, d.description as description " +
            "FROM dock as d " +
            "WHERE d.id = :dockId ", nativeQuery = true)
    Optional<DockSummary> findDockByDockId(@Param("dockId") Long dockId);

    @Query(value = "SELECT d.id as id, d.name as name, d.location as location, d.description as description " +
            "FROM dock as d ", nativeQuery = true)
    List<DockSummary> getAllDock();
}
