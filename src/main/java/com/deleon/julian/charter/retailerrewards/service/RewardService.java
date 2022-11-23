package com.deleon.julian.charter.retailerrewards.service;

import com.deleon.julian.charter.retailerrewards.model.Transaction;
import com.deleon.julian.charter.retailerrewards.repository.TransactionRepository;
import com.deleon.julian.charter.retailerrewards.response.Rewards;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class RewardService {

    private static final int MONTHS_FOR_TRANSACTION_REWARDS = 3;
    private TransactionRepository transactionRepository;

    public RewardService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Rewards getRewards(String userId) {
        List<Transaction> transactions = transactionRepository.getTransactionHistory(userId, MONTHS_FOR_TRANSACTION_REWARDS);
        long points = calculatePointsFromTransactions(transactions);
        return new Rewards(points);
    }

    private long calculatePointsFromTransactions(List<Transaction> transactions) {
        long points = 0;
        for (Transaction t: transactions) {
            points += calculatePointsFromTransaction(t);
        }
        return points;
    }

    private static long calculatePointsFromTransaction(Transaction t) {
        long dollars = t.getDollars();
        long points = 0;
        if (dollars > 50) {
            points = Math.min(50, dollars - 50);
        }
        if (dollars > 100) {
            points += (dollars - 100) * 2;
        }
        return points;
    }
}
