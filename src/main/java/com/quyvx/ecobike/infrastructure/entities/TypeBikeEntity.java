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
@Table(name = "type_bike")
public class TypeBikeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type_name")
    private String typeName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "type")
    private List<BikeEntity> bikeEntities;
}
