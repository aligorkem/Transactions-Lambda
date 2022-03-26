/**
 * The clean architecture and SOLID design principles applied to separate domain objects from external dependencies.
 *
 * @project aligorkem - Transactions List
 * @author  Ali Gorkem Ozturk
 * @date   21 Mar 22
 */

package com.aligorkem.example.core.usecases;

import com.aligorkem.example.core.domain.entities.Transaction;
import com.aligorkem.example.core.domain.interfaces.TransactionRepository;
import com.aligorkem.example.core.usecases.utils.TransactionValidator;

public final class CreateTransaction {

    private final TransactionRepository repository;

    public CreateTransaction(final TransactionRepository repository) {
        this.repository = repository;
    }

    /**
     * It creates a new transaction object.
     * @param transaction
     * @return
     * @throws Exception
     */
    public Transaction create(final Transaction transaction) throws Exception {
        TransactionValidator.validateCreateTransaction(transaction);
        return repository.create(transaction);
    }

}
