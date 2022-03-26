/**
 * The clean architecture and SOLID design principles applied to separate domain objects from external dependencies.
 *
 * @project aligorkem - Transactions List
 * @author  Ali Gorkem Ozturk
 * @date   21 Mar 22
 */

package com.aligorkem.example.config;

import com.aligorkem.example.core.domain.entities.Transaction;
import com.aligorkem.example.core.domain.entities.TransactionDetail;
import com.aligorkem.example.core.domain.interfaces.TransactionRepository;
import com.aligorkem.example.infrastructure.SlsTransactionRepository;
import com.aligorkem.example.core.usecases.*;

import java.util.List;
import java.util.Map;

/**
 * Serverless Frameworks config file.
 */
public final class SlsConfig {

    private final TransactionRepository transactionRepository = new SlsTransactionRepository();

    /**
     * It creates a transaction object in DynamoDB.
     * @param params
     * @return
     * @throws Exception
     */
    public Transaction createTransaction(Map<String, Object> params) throws Exception {
        CreateTransaction createTransaction = new CreateTransaction(this.transactionRepository);
        return createTransaction.create(Transaction.buildByParams(params));
    }

    /**
     * It returns all transactions.
     * @return
     * @throws Exception
     */
    public List<TransactionDetail> getTransactions() throws Exception {
        GetTransactions getTransactions = new GetTransactions(this.transactionRepository);
        return getTransactions.getList();
    }

    /**
     * It retrieves the transactions by is.
     * @param params
     * @return
     * @throws Exception
     */
    public TransactionDetail getTransaction(Map<String, String> params) throws Exception {
        GetTransactions getTransactions = new GetTransactions(this.transactionRepository);

        int id = 0;
        if(params.containsKey("id") ){
            id = Integer.parseInt(params.get("id"));
        }

        return getTransactions.getTransactionById(id);
    }
}
