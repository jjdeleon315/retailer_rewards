package com.deleon.julian.charter.retailerrewards.repository;

import com.deleon.julian.charter.retailerrewards.repository.entity.Purchase;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepositoryInMem extends CrudRepository<Purchase, Integer>, TransactionRepository {
    List<Purchase> findByUserId(String userId);
}
