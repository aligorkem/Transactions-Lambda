package com.aligorkem.example.core.domain.enums;


public enum TransactionType {
    TRANSFER("TRANSFER"),
    DEPOSIT("DEPOSIT"),
    WITHDRAWAL("WITHDRAWAL");

    private final String transactionType;

    TransactionType(final String transactionType) {
        this.transactionType = transactionType;
    }

    @Override
    public String toString() {
        return transactionType;
    }
}
