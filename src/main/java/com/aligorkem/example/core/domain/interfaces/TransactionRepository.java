/**
 * The clean architecture and SOLID design principles applied to separate domain objects from external dependencies.
 *
 * @project aligorkem - Transactions List
 * @author  Ali Gorkem Ozturk
 * @date   21 Mar 22
 */

package com.aligorkem.example.core.domain.interfaces;

import com.aligorkem.example.core.domain.entities.Transaction;
import com.aligorkem.example.core.domain.entities.TransactionDetail;

import java.util.List;

public interface TransactionRepository {

    /**
     * It creates a transaction object in DynamoDB.
     * @param transaction
     * @return
     */
    Transaction create(Transaction transaction);

    /**
     * It returns all transactions.
     * @return
     */
    List<TransactionDetail> getList();

    /**
     * It retrieves the transactions by is.
     * @param id
     * @return
     */
    TransactionDetail getTransactionById(int id);
}