/**
 * The clean architecture and SOLID design principles applied to separate domain objects from external dependencies.
 *
 * @project aligorkem - Transactions List
 * @author  Ali Gorkem Ozturk
 * @date   21 Mar 22
 */

package com.aligorkem.example.core.usecases.utils;

import com.aligorkem.example.core.domain.entities.Transaction;
import com.aligorkem.example.core.domain.exceptions.TransactionNullException;

public class TransactionValidator {

    private TransactionValidator() {
    }

    /**
     * It validatest the transaction object before creating it.
     * @param transaction
     * @throws Exception
     */
    public static void validateCreateTransaction(final Transaction transaction) throws Exception {
        if (transaction == null) {
            throw new TransactionNullException("Transaction cannot be null.");
        }

        if(transaction.getAccountName()== null || transaction.getAccountName().trim().isEmpty()){
            throw new TransactionNullException("AccountName cannot be null.");
        }

        if(transaction.getAccountNumber()== null || transaction.getAccountNumber() <= 0 ){
            throw new TransactionNullException("AccountNumber cannot be null or less than 0.");
        }

        if(transaction.getTransactionAmount()== null){
            throw new TransactionNullException("TransactionAmount cannot be null.");
        }
    }

}
