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
                .cvvCode(card.getCvvCode())
                .dateExpired(card.getDateExpired())
                .balance(card.getBalance())
                .secretToken(card.getSecretToken())
                .appCode(card.getAppCode())
                .build();
    }

    public Card entityToModel(CardEntity entity) {
        return Card.builder()
                .cardCode(entity.getCardCode())
                .cardHolderName(entity.getCardHolderName())
                .cvvCode(entity.getCvvCode())
                .dateExpired(entity.getDateExpired())
                .balance(entity.getBalance())
                .secretToken(entity.getSecretToken())
                .appCode(entity.getAppCode())
                .build();
    }
}
