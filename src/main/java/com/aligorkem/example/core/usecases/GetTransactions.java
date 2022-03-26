/**
 * The clean architecture and SOLID design principles applied to separate domain objects from external dependencies.
 *
 * @project aligorkem - Transactions List
 * @author  Ali Gorkem Ozturk
 * @date   21 Mar 22
 */

package com.aligorkem.example.core.usecases;

import com.aligorkem.example.core.domain.entities.TransactionDetail;
import com.aligorkem.example.core.domain.interfaces.TransactionRepository;

import java.util.List;

public final class GetTransactions {

    private final TransactionRepository repository;

    public GetTransactions(final TransactionRepository repository) {
        this.repository = repository;
    }

    /**
     * It returns all transactions.
     * @return
     */
    public List<TransactionDetail> getList() {
        return repository.getList();
    }

    /**
     * It retrieves the transactions by is.
     * @param id
     * @return
     */
    public TransactionDetail getTransactionById(int id) {
        return repository.getTransactionById(id);
    }
}