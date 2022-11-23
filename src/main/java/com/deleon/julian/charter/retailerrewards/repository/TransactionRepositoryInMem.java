package com.deleon.julian.charter.retailerrewards.repository;

import com.deleon.julian.charter.retailerrewards.model.Transaction;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionRepositoryInMem implements TransactionRepository {

    @Override
    public List<Transaction> getTransactionHistory(String userId, int months) {
        return List.of(
            new Transaction(10, getNow()),
            new Transaction(100, getNow().minus(Period.ofMonths(2).minusDays(10))),
            new Transaction(150, getNow().minus(Period.ofMonths(2).minusDays(3)))
        );
    }

    private static OffsetDateTime getNow() {
        return Instant.now().atOffset(ZoneOffset.UTC);
    }
}
