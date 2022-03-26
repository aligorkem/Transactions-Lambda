package com.aligorkem.example.infrastructure;

import com.aligorkem.example.core.domain.entities.TransactionDetail;
import com.aligorkem.example.core.domain.enums.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MockDatastore {
    private final List<TransactionDetail> transactionList;

    public MockDatastore() {
        transactionList = initialiseTransactionList();
    }

    public List<TransactionDetail> getTransactionList() {
        return transactionList;
    }

    private List<TransactionDetail> initialiseTransactionList() {
        TransactionDetail transfer = new TransactionDetail(
                1L,
                12345L,
                "ABC Bank",
                "ABC/12345",
                456L,
                "DSMITHMR",
                "Dan",
                "Smith",
                TransactionType.TRANSFER,
                new BigDecimal("10000.00"),
                LocalDate.of(2021,6,10)
        );
        TransactionDetail deposit = new TransactionDetail(
                2L,
                12345L,
                "ABC Bank",
                "ABC/12345",
                456L,
                "DSMITHMR",
                "Dan",
                "Smith",
                TransactionType.DEPOSIT,
                new BigDecimal("1300.00"),
                LocalDate.of(2021,6,11)
        );
        TransactionDetail withdrawal = new TransactionDetail(
                3L,
                12345L,
                "ABC Bank",
                "ABC/12345",
                456L,
                "DSMITHMR",
                "Dan",
                "Smith",
                TransactionType.WITHDRAWAL,
                new BigDecimal("800.00"),
                LocalDate.of(2021,6,14)
        );

        List<TransactionDetail> transactionList = new ArrayList<>();

        transactionList.add(transfer);
        transactionList.add(deposit);
        transactionList.add(withdrawal);

        return transactionList;
    }
}
