package com.quyvx.ecobike.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "card")
public class CardEntity {
    @Id
    @Column(name = "card_code", unique = true)
    private String cardCode;

    @Column(name = "card_holder_name")
    private String cardHolderName;

    @Column(name = "balance")
    private long balance;

    @Column(name = "secret_code", columnDefinition = "uuid", updatable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID secretToken;
}
