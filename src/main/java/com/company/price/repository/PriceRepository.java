package com.zenjob.challenge.repository;

import com.zenjob.challenge.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PriceRepository extends JpaRepository<Price, UUID> {

    List<Price> findAllByProductIdAndBrandId(Integer productId, Integer brandId);


    //@Query(value = "select p from Price p where p.startDate <= ?1 and p.endDate >= ?1 and p.productId = ?2 and p.brandId = ?3 order by p.priority", nativeQuery = true)
    @Query(value = "select * from Price p where p.start_date <= ?1 and p.end_date > ?1 and p.product_id = ?2 and p.brand_id = ?3 order by p.priority desc LIMIT 1", nativeQuery = true)
    Price findAllByProductIdAndBrandIdSorted(String applicationDate, Integer productId, Integer brandId);
}
