package com.company.price.repository;

import com.company.price.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PriceRepository extends JpaRepository<Price, UUID> {

    @Query(value = "select * from Price p where p.start_date <= ?1 and p.end_date > ?1 and p.product_id = ?2 and p.brand_id = ?3 order by p.priority desc LIMIT 1", nativeQuery = true)
    Price findAllByProductIdAndBrandIdSorted(String applicationDate, Integer productId, Integer brandId);
}
