package com.quyvx.ecobike.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//@Getter
//@Setter
//@Entity
//@Table(name = "bike_tracker")
public class BikeTrackerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
