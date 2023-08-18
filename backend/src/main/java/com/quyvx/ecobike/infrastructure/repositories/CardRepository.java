package com.quyvx.ecobike.infrastructure.repositories;

import com.quyvx.ecobike.domain.aggregate_models.Card;
import com.quyvx.ecobike.domain.repositories.ICardRepository;
import com.quyvx.ecobike.infrastructure.entities.CardEntity;
import com.quyvx.ecobike.infrastructure.entity_mapper.CardEntityMapper;
import com.quyvx.ecobike.infrastructure.jpa_repositories.CardJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CardRepository implements ICardRepository {
    private final CardJpaRepository cardJpaRepository;
    private final CardEntityMapper mapper;
    @Override
    public Card save(Card card) {
        CardEntity entity = cardJpaRepository.saveAndFlush(mapper.modelToEntity(card));
        return mapper.entityToModel(entity);
    }

    @Override
    public Optional<Card> findByCardCode(String cardCode) {
        return cardJpaRepository.findById(cardCode).map(mapper::entityToModel);
    }
}
