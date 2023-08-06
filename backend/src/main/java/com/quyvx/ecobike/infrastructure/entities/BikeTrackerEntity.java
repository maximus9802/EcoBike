package com.quyvx.ecobike.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "bike_tracker")
public class BikeTrackerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime start;

    private LocalDateTime end;

    @ManyToOne
    @JoinColumn(name= "type_tracker_id", referencedColumnName = "id")
    private TypeTrackerEntity typeTracker;

    @OneToOne
    @JoinColumn(name = "bike_id", referencedColumnName = "id")
    private BikeEntity bike;
}
