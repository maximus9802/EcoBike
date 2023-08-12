package com.quyvx.ecobike.infrastructure.jpa_repositories;

import com.quyvx.ecobike.infrastructure.entities.TypeTrackerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeTrackerJpaRepository extends JpaRepository<TypeTrackerEntity, Long>, JpaSpecificationExecutor<TypeTrackerEntity> {
    @Query(value = "SELECT tt.id FROM type_tracker as tt WHERE tt.name = :name", nativeQuery = true)
    Long findTypeIdByTypeName(@Param("name") String name);
    @Query(value = "SELECT tt.name FROM type_tracker as tt WHERE tt.id = :typeId", nativeQuery = true)
    String findTypeNameByTypeId(@Param("typeId") Long typeId);

}
