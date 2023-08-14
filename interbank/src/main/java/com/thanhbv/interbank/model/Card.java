package com.thanhbv.interbank.model;

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
public class Card {
    @Id
    @Column(name = "card_code", unique = true)
    private String cardCode;

    @Column(name = "card_holder_name")
    private String cardHolderName;

    @Column(name = "cvv_code")
    private String cvvCode;

    @Column(name = "date_expired")
    private String dateExpired;

    @Column(name = "balance")
    private long balance;

    @Column(name = "secret_code", columnDefinition = "uuid", updatable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID secretToken;

    @Column(name = "app_code", columnDefinition = "uuid", updatable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID appCode;
}
