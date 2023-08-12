package com.quyvx.ecobike.infrastructure.entities;

import com.quyvx.ecobike.domain.aggregate_models.BikeTracker;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "bike")
public class BikeEntity  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private BigDecimal price;

    private Long battery;

    @Column(name = "code", columnDefinition = "uuid", updatable = false)
    private UUID code;

    @Column(name = "link_image")
    private String linkImage;

    @Column(name = "license_plate")
    private String licensePlate;

    private BigDecimal deposit;

    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    private TypeBikeEntity type;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private StatusBikeEnitity status;

    @ManyToOne
    @JoinColumn(name = "dock_id", referencedColumnName = "id")
    private DockEntity dock;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "bike")
    private BikeTrackerEntity tracker;
}
