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
@Table(name = "dock")
public class DockEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String location;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dock")
    private List<BikeEntity> bikes;
}
