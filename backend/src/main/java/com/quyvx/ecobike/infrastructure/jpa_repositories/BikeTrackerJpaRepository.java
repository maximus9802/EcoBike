package com.quyvx.ecobike.infrastructure.jpa_repositories;

import com.quyvx.ecobike.infrastructure.entities.BikeTrackerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BikeTrackerJpaRepository extends JpaRepository<BikeTrackerEntity, Long>, JpaSpecificationExecutor<BikeTrackerEntity> {
}
