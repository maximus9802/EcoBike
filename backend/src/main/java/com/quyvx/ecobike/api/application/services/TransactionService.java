package com.quyvx.ecobike.api.application.services;

import com.quyvx.ecobike.api.dto.card.ProcessTransactionResDto;
import com.quyvx.ecobike.api.dto.card.TransactionDto;
import com.quyvx.ecobike.domain.aggregate_models.Transaction;
import com.quyvx.ecobike.infrastructure.repositories.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;
    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public Transaction convertIntoTransaction(ProcessTransactionResDto processTransactionResDto) {
        TransactionDto dto = processTransactionResDto.getTransaction();
        return Transaction.builder()
                .transactionId(dto.getTransactionId())
                .errorCode(processTransactionResDto.getErrorCode())
                .cardCode(dto.getCardCode())
                .owner(dto.getOwner())
                .cvvCode(dto.getCvvCode())
                .command(dto.getCommand())
                .dateExpired(dto.getDateExpired())
                .transactionContent(dto.getTransactionContent())
                .amount(dto.getAmount())
                .createdAt(dto.getCreatedAt())
                .build();
    }
}
