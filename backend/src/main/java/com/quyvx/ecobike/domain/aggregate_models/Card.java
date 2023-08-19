package com.quyvx.ecobike.domain.aggregate_models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;


import java.util.UUID;
@Getter
@Setter
@SuperBuilder
@Slf4j
@NoArgsConstructor

public class Card {
    private String cardCode;
    private String cardHolderName;
    private String cvvCode;
    private String dateExpired;
    private long balance;
}
