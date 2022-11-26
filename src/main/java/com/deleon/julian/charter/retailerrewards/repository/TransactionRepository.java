package com.deleon.julian.charter.retailerrewards.repository;

import com.deleon.julian.charter.retailerrewards.repository.entity.Purchase;
import java.util.List;

public interface TransactionRepository {
    List<Purchase> findByUserId(String userId);
}
