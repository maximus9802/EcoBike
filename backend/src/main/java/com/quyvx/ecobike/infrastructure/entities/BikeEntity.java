package com.quyvx.ecobike.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;


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

    @Column(name = "link_image")
    private String linkImage;

    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    private TypeBikeEntity type;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private StatusBikeEnitity status;

    @ManyToOne
    @JoinColumn(name = "dock_id", referencedColumnName = "id")
    private DockEntity dock;
}
