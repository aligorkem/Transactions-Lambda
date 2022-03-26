/**
 * The clean architecture and SOLID design principles applied to separate domain objects from external dependencies.
 *
 * @project aligorkem - Transactions List
 * @author  Ali Gorkem Ozturk
 * @date   21 Mar 22
 */

package com.aligorkem.example.infrastructure;

import com.aligorkem.example.core.domain.entities.Transaction;
import com.aligorkem.example.core.domain.entities.TransactionDetail;
import com.aligorkem.example.core.domain.interfaces.TransactionRepository;
import java.util.List;

public class SlsTransactionRepository implements TransactionRepository {

    @Override
    public Transaction create(final Transaction transaction) {
        transaction.setTransactionDate(System.currentTimeMillis());
        return transaction;
    }

    @Override
    public List<TransactionDetail> getList() {
        MockDatastore datastore = new MockDatastore();
        return datastore.getTransactionList();
    }

    @Override
    public TransactionDetail getTransactionById(int id) {
        MockDatastore datastore = new MockDatastore();
        List<TransactionDetail> transactionDetails = datastore.getTransactionList();
        TransactionDetail transaction = transactionDetails.stream().filter(value -> value.getId() == id).findFirst().orElse(null);
        return transaction;
    }
}