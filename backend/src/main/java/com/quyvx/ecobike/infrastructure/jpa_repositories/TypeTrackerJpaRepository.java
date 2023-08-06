package com.quyvx.ecobike.infrastructure.jpa_repositories;

import com.quyvx.ecobike.infrastructure.entities.TypeTrackerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeTrackerJpaRepository extends JpaRepository<TypeTrackerEntity, Long>, JpaSpecificationExecutor<TypeTrackerEntity> {
}
