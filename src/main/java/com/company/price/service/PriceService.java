package com.company.price.service;

import com.company.price.entity.Price;
import com.company.price.exceptions.PriceNotFoundException;
import com.company.price.repository.PriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.*;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class PriceService {
    private final PriceRepository priceRepository;

    public List<Price> getPrices() {
        return priceRepository.findAll();
    }

    public Price getPriceForApplicationDate(LocalDateTime applicationDate, Integer productId, Integer brandId) throws PriceNotFoundException {
        Price priceFromDb = priceRepository.findAllByProductIdAndBrandIdSorted(Timestamp.valueOf(applicationDate).toString().substring(0, 19), productId, brandId);
        if (priceFromDb == null) {
            throw new PriceNotFoundException();
        }
        return priceFromDb;
    }


}
