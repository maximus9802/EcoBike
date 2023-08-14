package com.quyvx.ecobike.domain.repositories;

import com.quyvx.ecobike.domain.aggregate_models.Card;

import java.util.Optional;

public interface ICardRepository {
    Card save(Card card);
    Optional<Card> findByCardCode(String cardCode);
}
