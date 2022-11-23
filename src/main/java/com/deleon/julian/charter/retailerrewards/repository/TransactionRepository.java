package com.deleon.julian.charter.retailerrewards.repository;

import com.deleon.julian.charter.retailerrewards.model.Transaction;
import java.util.List;

public interface TransactionRepository {
    List<Transaction> getTransactionHistory(String userId, int months);
}
