package com.deleon.julian.charter.retailerrewards.service;

import com.deleon.julian.charter.retailerrewards.repository.TransactionRepository;
import com.deleon.julian.charter.retailerrewards.repository.entity.Purchase;
import com.deleon.julian.charter.retailerrewards.response.Rewards;
import java.time.Instant;
import java.time.Period;
import java.time.ZoneOffset;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class RewardService {

    private TransactionRepository transactionRepository;

    public RewardService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Rewards getRewards(String userId) {
        List<Purchase> purchases = transactionRepository.findByUserId(userId);
        long points = calculatePointsFromTransactions(purchases);
        return new Rewards(points);
    }

    private long calculatePointsFromTransactions(List<Purchase> purchases) {
        long points = 0;
        var threeMonthsAgo = Instant.now().atOffset(ZoneOffset.UTC).minus(Period.ofMonths(3));
        for (var t: purchases) {
            if (t.getCreatedAt().isAfter(threeMonthsAgo)) {
                points += calculatePointsFromTransaction(t);
            }
        }
        return points;
    }

    private static long calculatePointsFromTransaction(Purchase t) {
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
