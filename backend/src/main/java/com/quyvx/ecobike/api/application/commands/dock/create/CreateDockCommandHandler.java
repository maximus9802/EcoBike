package com.quyvx.ecobike.api.application.commands.dock.create;

import an.awesome.pipelinr.Command;
import com.quyvx.ecobike.domain.aggregate_models.Dock;
import com.quyvx.ecobike.domain.repositories.IDockRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@AllArgsConstructor
@Component
public class CreateDockCommandHandler implements Command.Handler<CreateDockCommand, Dock> {
    private final IDockRepository dockRepository;

    @Override
    public Dock handle(CreateDockCommand command) {
        Dock dock = Dock.builder()
                .name(command.getName())
                .description(command.getDescription())
                .location(command.getLocation())
                .build();
        Dock savedDock = dockRepository.save(dock);
        log.info("----- CreateDockCommand: dock was created: {}", savedDock.getId());
        return savedDock;
    }
}
