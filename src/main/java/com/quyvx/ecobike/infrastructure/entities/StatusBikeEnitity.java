package com.quyvx.ecobike.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "status_bike")
public class StatusBikeEnitity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status_name")
    private String statusName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "status")
    private List<BikeEntity> bikeEntities;
}
