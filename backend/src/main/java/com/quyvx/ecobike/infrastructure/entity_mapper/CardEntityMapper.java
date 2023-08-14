package com.quyvx.ecobike.infrastructure.entity_mapper;

import com.quyvx.ecobike.domain.aggregate_models.Card;
import com.quyvx.ecobike.infrastructure.entities.CardEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CardEntityMapper {
    public CardEntity modelToEntity(Card card) {
        return CardEntity.builder()
                .cardCode(card.getCardCode())
                .cardHolderName(card.getCardHolderName())
                .balance(card.getBalance())
                .secretToken(card.getSecretToken())
                .build();
    }

    public Card entityToModel(CardEntity entity) {
        return Card.builder()
                .cardCode(entity.getCardCode())
                .cardHolderName(entity.getCardHolderName())
                .balance(entity.getBalance())
                .secretToken(entity.getSecretToken())
                .build();
    }
}
