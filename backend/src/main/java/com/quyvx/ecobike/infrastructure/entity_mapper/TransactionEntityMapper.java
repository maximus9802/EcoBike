package com.quyvx.ecobike.infrastructure.entity_mapper;

import com.quyvx.ecobike.domain.aggregate_models.Transaction;
import com.quyvx.ecobike.infrastructure.entities.TransactionEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransactionEntityMapper {
    public TransactionEntity modelToEntity(Transaction transaction) {
        return TransactionEntity.builder()
                .transactionId(transaction.getTransactionId())
                .cardCode(transaction.getCardCode())
                .owner(transaction.getOwner())
                .cvvCode(transaction.getCvvCode())
                .dateExpired(transaction.getDateExpired())
                .command(transaction.getCommand())
                .transactionContent(transaction.getTransactionContent())
                .amount(transaction.getAmount())
                .createdAt(transaction.getCreatedAt())
                .errorCode(transaction.getErrorCode())
                .build();
    }

    public Transaction entityToModel(TransactionEntity entity) {
        return Transaction.builder()
                .transactionId(entity.getTransactionId())
                .cardCode(entity.getCardCode())
                .owner(entity.getOwner())
                .cvvCode(entity.getCvvCode())
                .dateExpired(entity.getDateExpired())
                .command(entity.getCommand())
                .transactionContent(entity.getTransactionContent())
                .amount(entity.getAmount())
                .createdAt(entity.getCreatedAt())
                .errorCode(entity.getErrorCode())
                .build();
    }
}
