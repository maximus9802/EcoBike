package com.quyvx.ecobike.infrastructure.repositories;

import com.quyvx.ecobike.domain.aggregate_models.Transaction;
import com.quyvx.ecobike.domain.repositories.ITransactionRepository;
import com.quyvx.ecobike.infrastructure.entities.TransactionEntity;
import com.quyvx.ecobike.infrastructure.entity_mapper.TransactionEntityMapper;
import com.quyvx.ecobike.infrastructure.jpa_repositories.TransactionJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransactionRepository implements ITransactionRepository {
    private final TransactionJpaRepository transactionJpaRepository;
    private final TransactionEntityMapper mapper;
    @Override
    public Transaction save(Transaction transaction) {
        TransactionEntity entity = transactionJpaRepository.saveAndFlush(mapper.modelToEntity(transaction));
        return mapper.entityToModel(entity);
    }
}
