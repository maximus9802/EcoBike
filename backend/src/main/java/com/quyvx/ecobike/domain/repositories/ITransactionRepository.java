package com.quyvx.ecobike.domain.repositories;

import com.quyvx.ecobike.domain.aggregate_models.Transaction;

public interface ITransactionRepository {
    Transaction save(Transaction transaction);
}
