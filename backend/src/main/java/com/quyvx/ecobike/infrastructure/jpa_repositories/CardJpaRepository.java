package com.quyvx.ecobike.infrastructure.jpa_repositories;

import com.quyvx.ecobike.infrastructure.entities.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.lang.NonNull;

import java.util.Optional;

public interface CardJpaRepository extends JpaRepository<CardEntity, String>, JpaSpecificationExecutor<CardEntity> {
    Optional<CardEntity> findById(@NonNull String cardCode);
}
