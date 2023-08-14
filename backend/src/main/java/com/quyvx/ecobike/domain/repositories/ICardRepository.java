package com.quyvx.ecobike.domain.repositories;

import com.quyvx.ecobike.domain.aggregate_models.Card;

public interface ICardRepository {
    Card save(Card card);
}
