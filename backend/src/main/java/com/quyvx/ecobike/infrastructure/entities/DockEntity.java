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

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "link_image", columnDefinition = "TEXT")
    private String linkImage;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dock")
    private List<BikeEntity> bikes;
}
