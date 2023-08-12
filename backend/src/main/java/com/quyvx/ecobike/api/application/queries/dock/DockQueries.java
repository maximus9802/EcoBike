package com.quyvx.ecobike.api.application.queries.dock;

import com.quyvx.ecobike.domain.aggregate_models.Dock;
import com.quyvx.ecobike.infrastructure.repositories.DockRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class DockQueries {
    private final DockRepository dockRepository;

    public List<Dock> getAllDocks() {
        return dockRepository.findAll();
    }

}
