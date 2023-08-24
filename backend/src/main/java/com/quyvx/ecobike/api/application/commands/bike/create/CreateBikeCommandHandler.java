package com.quyvx.ecobike.api.application.commands.bike.create;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Pipeline;
import com.quyvx.ecobike.api.application.commands.bike.update.UpdateBikeCommand;
import com.quyvx.ecobike.api.application.commands.tracker.update.UpdateTrackerCommand;
import com.quyvx.ecobike.api.application.queries.status.StatusQueries;
import com.quyvx.ecobike.api.application.queries.typebike.TypeBikeQueries;
import com.quyvx.ecobike.domain.aggregate_models.Bike;
import com.quyvx.ecobike.domain.aggregate_models.BikeTracker;
import com.quyvx.ecobike.domain.aggregate_models.TypeBike;
import com.quyvx.ecobike.domain.repositories.IBikeRepository;
import com.quyvx.ecobike.domain.repositories.IBikeTrackerRepository;
import com.quyvx.ecobike.domain.repositories.ITypeBikeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Component
public class CreateBikeCommandHandler implements Command.Handler<CreateBikeCommand, Bike> {

    private final IBikeRepository bikeRepository;
    private final IBikeTrackerRepository bikeTrackerRepository;
    private final ITypeBikeRepository typeBikeRepository;
    private final TypeBikeQueries typeBikeQueries;
    private final StatusQueries statusQueries;
    private final Pipeline pipeline;

    @Override
    public Bike handle(CreateBikeCommand command) {

        List<String> types = typeBikeQueries.findAllType();

        if(types.contains(command.getTypeName())){
            Bike bike = Bike.builder()
                    .price(command.getPrice())
                    .typeId(typeBikeQueries.findTypeIdByTypeName(command.getTypeName()))
                    .statusId(statusQueries.findStatusIdByStatusName("free"))
                    .description(command.getDescription())
                    .linkImage(command.getLinkImage())
                    .battery(command.getBattery())
                    .dockId(command.getDockId())
                    .licensePlate(command.getLicensePlate())
                    .deposit(command.getDeposit())
                    .build();
            Bike savedBike = bikeRepository.save(bike);
            log.info("----- CreateBikeCommandHandler: eco bike was created: #{}", savedBike.getId());
            return savedBike;
        }
        else {
            TypeBike newTypeBike = TypeBike.builder()
                    .typeName(command.getTypeName())
                    .build();
            newTypeBike = typeBikeRepository.save(newTypeBike);
            log.info("----- CreateBikeCommandHandler: new {} type was created: {}", newTypeBike.getTypeName(), newTypeBike.getId());

            Bike bike = Bike.builder()
                    .price(command.getPrice())
                    .typeId(typeBikeQueries.findTypeIdByTypeName(command.getTypeName()))
                    .statusId(statusQueries.findStatusIdByStatusName("free"))
                    .description(command.getDescription())
                    .linkImage(command.getLinkImage())
                    .battery(command.getBattery())
                    .dockId(command.getDockId())
                    .licensePlate(command.getLicensePlate())
                    .deposit(command.getDeposit())
                    .build();
            Bike savedBike = bikeRepository.save(bike);
            log.info("----- CreateBikeCommandHandler: {} type bike was created: {}", newTypeBike.getTypeName() ,savedBike.getId());

            return savedBike;
        }

    }
}
