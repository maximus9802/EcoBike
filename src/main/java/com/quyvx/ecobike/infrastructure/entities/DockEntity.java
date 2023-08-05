package com.quyvx.ecobike.infrastructure.entities;

import com.quyvx.ecobike.domain.aggregate_models.Bike;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "dock")
public class DockEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String location;

    private String name;

    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dock")
    private List<BikeEntity> bikes;
}
