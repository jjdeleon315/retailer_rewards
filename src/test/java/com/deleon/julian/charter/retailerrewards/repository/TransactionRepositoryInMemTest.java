package com.deleon.julian.charter.retailerrewards.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TransactionRepositoryInMemTest {
    private TransactionRepository transactionRepository = new TransactionRepositoryInMem();

    @Test
    void getTransactions() {
        var transactions = transactionRepository.getTransactionHistory("userId", 3);
    }
}
