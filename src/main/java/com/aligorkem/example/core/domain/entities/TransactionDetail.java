package com.aligorkem.example.core.domain.entities;

import com.aligorkem.example.core.domain.enums.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TransactionDetail {

    private Long id;

    private Long bankAccountId;
    private String bankAccountName;
    private String bankAccountNumber;

    private Long customerId;
    private String customerReference;
    private String customerFirstName;
    private String customerLastName;

    private TransactionType transactionType;
    private BigDecimal transactionAmount;
    private LocalDate transactionDate;

    public TransactionDetail(Long id, Long bankAccountId, String bankAccountName,
                       String bankAccountNumber, Long customerId, String customerReference,
                       String customerFirstName, String customerLastName, TransactionType transactionType,
                       BigDecimal transactionAmount, LocalDate transactionDate) {
        this.id = id;
        this.bankAccountId = bankAccountId;
        this.bankAccountName = bankAccountName;
        this.bankAccountNumber = bankAccountNumber;
        this.customerId = customerId;
        this.customerReference = customerReference;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
        this.transactionDate = transactionDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(Long bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public String getBankAccountName() {
        return bankAccountName;
    }

    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerReference() {
        return customerReference;
    }

    public void setCustomerReference(String customerReference) {
        this.customerReference = customerReference;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }
}
