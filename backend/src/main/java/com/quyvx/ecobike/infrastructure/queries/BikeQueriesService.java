package com.quyvx.ecobike.infrastructure.queries;

import com.quyvx.ecobike.api.application.models.bike.BikeDetails;
import com.quyvx.ecobike.api.application.models.bike.BikeInfo;
import com.quyvx.ecobike.api.application.models.bike.BikeSummary;
import com.quyvx.ecobike.api.application.queries.bike.IBikeQueriesService;
import com.quyvx.ecobike.infrastructure.entities.BikeEntity;
import com.quyvx.ecobike.infrastructure.jpa_repositories.BikeJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class BikeQueriesService implements IBikeQueriesService {
    private final BikeJpaRepository bikeJpaRepository;

    @Override
    public Optional<BikeEntity> findById(Long id) {
        return bikeJpaRepository.findById(id);
    }

    @Override
    public String findStatusBikeByLongId(Long id) {
        return bikeJpaRepository.findStatusBikeById(id);
    }

    @Override
    public Optional<BikeDetails> findBikeWithoutTracker(Long id) {
        return bikeJpaRepository.findByWithoutTracker(id);
    }

    public List<BikeDetails> getAllBikeDetails() {
        return bikeJpaRepository.findAll().stream()
                .map(bikeEntity -> findBikeWithoutTracker(bikeEntity.getId()).orElse(null))
                .toList();
    }

    @Override
    public Integer countBikeAvailable(Long dockId) {
        return bikeJpaRepository.countBikeAvailableByDockId(dockId);
    }

    @Override
    public List<BikeInfo> getAllBikeInDock(Long dockId) {
        return bikeJpaRepository.getBikeInfoInDock(dockId);
    }
}
