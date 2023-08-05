package com.quyvx.ecobike.infrastructure.jpa_repositories;


import com.quyvx.ecobike.infrastructure.entities.StatusBikeEnitity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusJpaRepository extends JpaRepository<StatusBikeEnitity, Long>, JpaSpecificationExecutor<StatusBikeEnitity> {
    @Query(value = "SELECT s.id as id " +
            "FROM status_bike s " +
            "WHERE s.status_name = :statusName",
            nativeQuery = true)
    Long findStatusIdByStatusName(@Param("statusName") String statusName);
}
