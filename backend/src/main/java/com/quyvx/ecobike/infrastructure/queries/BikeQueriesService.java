package com.quyvx.ecobike.infrastructure.queries;

import com.quyvx.ecobike.api.application.queries.bike.IBikeQueriesService;
import com.quyvx.ecobike.infrastructure.entities.BikeEntity;
import com.quyvx.ecobike.infrastructure.jpa_repositories.BikeJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class BikeQueriesService implements IBikeQueriesService {
    private final BikeJpaRepository bikeJpaRepository;

    @Override
    public Optional<BikeEntity> findById(Long id) {
        return bikeJpaRepository.findById(id);
    }
}