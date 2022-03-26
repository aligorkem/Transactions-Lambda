/**
 * The clean architecture and SOLID design principles applied to separate domain objects from external dependencies.
 *
 * @project aligorkem - Transactions List
 * @author  Ali Gorkem Ozturk
 * @date   21 Mar 22
 */

package com.aligorkem.example.core.domain.entities;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Transaction entity.
 */
public class Transaction {

    private String id;
    private String accountName;
    private Long accountNumber;
    private BigDecimal transactionAmount;
    private Long transactionDate;

    public Transaction( String id, String accountName, Long accountNumber, BigDecimal transactionAmount, Long transactionDate) {
        this.id = id;
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.transactionAmount = transactionAmount;
        this.transactionDate = transactionDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Long getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Long transactionDate) {
        this.transactionDate = transactionDate;
    }

    /**
     * It genereates a new Transaction obejct from given params.
     * @param params
     * @return
     */
    public static Transaction buildByParams(Map<String, Object> params){
        String id = null;
        String accountName = null;
        Long accountNumber = null;
        BigDecimal transactionAmount = null;
        Long transactionDate = null;

        if(params.containsKey("accountName") ){
            accountName = params.get("accountName").toString();
        }

        if(params.containsKey("accountNumber") ){
            accountNumber = Long.parseLong(params.get("accountNumber").toString());
        }

        if(params.containsKey("transactionAmount") ){
            transactionAmount = new BigDecimal(params.get("transactionAmount").toString());
        }

        if(params.containsKey("transactionDate") ){
            transactionDate = Long.parseLong(params.get("transactionDate").toString());
        }

        return new Transaction( id, accountName, accountNumber, transactionAmount, transactionDate);
    }
}