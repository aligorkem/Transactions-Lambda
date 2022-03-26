/**
 * This sample project demonstrates how to implement a reliable, scalable, and maintainable java application with serverless framework.
 * The clean architecture and SOLID design principles applied to separate domain objects from external dependencies.
 *
 * @project aligorkem - Transactions List
 * @author  Ali Gorkem Ozturk
 * @date   21 Mar 22
 */

package com.aligorkem.example.core.domain.exceptions;

public class TransactionNullException extends Exception {

    public TransactionNullException(String message){
        super(message);
    }
}
