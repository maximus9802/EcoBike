package com.quyvx.ecobike.api.application.commands.bike.update;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Pipeline;
import com.quyvx.ecobike.api.application.commands.tracker.update.UpdateTrackerCommand;
import com.quyvx.ecobike.domain.aggregate_models.Bike;
import com.quyvx.ecobike.infrastructure.repositories.BikeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Slf4j
@Component
public class UpdateBikeCommandHandle implements Command.Handler<UpdateBikeCommand, Bike> {
    private final BikeRepository bikeRepository;
    private final Pipeline pipeline;
    @Override
    public Bike handle(UpdateBikeCommand command) {
        Bike bike = bikeRepository.findById(command.getId()).orElseThrow(()-> new RuntimeException("Not found bike"));

        Bike.BikeBuilder<?,?> bikeBuilder = Bike.builder()
                .id(command.getId())
                .typeId(command.getTypeId())
                .battery(command.getBattery())
                .linkImage(command.getLinkImage())
                .description(command.getDescription())
                .statusId(command.getStatusId())
                .code(command.getCode())
                .price(command.getPrice())
                .dockId(command.getDockId());
        bike = bikeRepository.save(bikeBuilder.build());
        log.info("----- UpdateBikeCommandHandle: update bike successful.");
        return bike;
    }
}
