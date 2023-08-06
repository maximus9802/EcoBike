package com.quyvx.ecobike.infrastructure.jpa_repositories;

import com.quyvx.ecobike.infrastructure.entities.TypeBikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeBikeJpaRepository extends JpaRepository<TypeBikeEntity, Long>, JpaSpecificationExecutor<TypeBikeEntity> {
    @Query(value = "SELECT t.id FROM type_bike t WHERE t.type_name = :name ", nativeQuery = true)
    Long findTypeIdByTypeName(@Param("name") String name);

    @Query(value = "SELECT t.type_name FROM type_bike as t", nativeQuery = true)
    List<String> findAllType();
}
