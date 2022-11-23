package com.deleon.julian.charter.retailerrewards.model;

import java.time.Instant;
import java.time.OffsetDateTime;

public class Transaction {
    private Integer dollars;
    private OffsetDateTime createdAt;

    public Transaction(Integer dollars, OffsetDateTime createdAt) {
        this.dollars = dollars;
        this.createdAt = createdAt;
    }

    public Integer getDollars() {
        return dollars;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }
}
