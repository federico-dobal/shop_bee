package com.company.price.controller;

import com.company.price.Application;
import com.company.price.dto.ResponseDto;
import com.company.price.exceptions.PriceNotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class PriceControllerTest {

    @Autowired
    private PriceController priceController;

    PriceController.RequestPriceRequestDto jobRequestDto = new PriceController.RequestPriceRequestDto();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private static final Integer BRAND_ID     = 1;
    private static final Integer PRODUCT_ID   = 35455;
    private static final String  CURRENCY_EUR = "EUR";

    @Before
    public void setUp() {
        jobRequestDto.setBrandId(BRAND_ID);
        jobRequestDto.setProductId(PRODUCT_ID);
    }

    @Test
    public void getPrice14JuneAt10() throws PriceNotFoundException {
        //GIVEN a price request with date 2020-06-14 10:00:00
        LocalDateTime applicationDate = LocalDateTime.parse("2020-06-14 10:00:00", formatter);
        jobRequestDto.setApplicationDate(applicationDate);

        // WHEN the price is requested
        ResponseDto<PriceController.PriceResponse> response = priceController.getPrices(jobRequestDto);

        // THEN expected price is returned
        assertThat(response.getData().productId).isEqualTo(PRODUCT_ID);
        assertThat(response.getData().brandId).isEqualTo(BRAND_ID);
        assertThat(response.getData().currency).isEqualTo(CURRENCY_EUR);
        assertThat(response.getData().applicationDate).isEqualTo(applicationDate);
        assertThat(response.getData().price).isEqualTo(35.5f);

    }

    @Test
    public void getPrice14JuneAt16() throws PriceNotFoundException {
        //GIVEN a price request with date 2020-06-14 16:00:00
        LocalDateTime applicationDate = LocalDateTime.parse("2020-06-14 16:00:00", formatter);
        jobRequestDto.setApplicationDate(applicationDate);

        // WHEN the price is requested
        ResponseDto<PriceController.PriceResponse> response = priceController.getPrices(jobRequestDto);

        // THEN expected price is returned
        assertThat(response.getData().productId).isEqualTo(PRODUCT_ID);
        assertThat(response.getData().brandId).isEqualTo(BRAND_ID);
        assertThat(response.getData().currency).isEqualTo(CURRENCY_EUR);
        assertThat(response.getData().applicationDate).isEqualTo(applicationDate);
        assertThat(response.getData().price).isEqualTo(25.45f);

    }

    @Test
    public void getPrice14JuneAt21() throws PriceNotFoundException {
        //GIVEN a price request with date 2020-06-14 21:00:00
        LocalDateTime applicationDate = LocalDateTime.parse("2020-06-14 21:00:00", formatter);
        jobRequestDto.setApplicationDate(applicationDate);

        // WHEN the price is requested
        ResponseDto<PriceController.PriceResponse> response = priceController.getPrices(jobRequestDto);

        // THEN expected price is returned
        assertThat(response.getData().productId).isEqualTo(PRODUCT_ID);
        assertThat(response.getData().brandId).isEqualTo(BRAND_ID);
        assertThat(response.getData().currency).isEqualTo(CURRENCY_EUR);
        assertThat(response.getData().applicationDate).isEqualTo(applicationDate);
        assertThat(response.getData().price).isEqualTo(35.5f);

    }

    @Test
    public void getPrice15JuneAt10() throws PriceNotFoundException {
        //GIVEN a price request with date 2020-06-15 10:00:00
        LocalDateTime applicationDate = LocalDateTime.parse("2020-06-15 10:00:00", formatter);
        jobRequestDto.setApplicationDate(applicationDate);

        // WHEN the price is requested
        ResponseDto<PriceController.PriceResponse> response = priceController.getPrices(jobRequestDto);

        // THEN expected price is returned
        assertThat(response.getData().productId).isEqualTo(PRODUCT_ID);
        assertThat(response.getData().brandId).isEqualTo(BRAND_ID);
        assertThat(response.getData().currency).isEqualTo(CURRENCY_EUR);
        assertThat(response.getData().applicationDate).isEqualTo(applicationDate);
        assertThat(response.getData().price).isEqualTo(30.5f);

    }

    @Test
    public void getPrice15JuneAt16() throws PriceNotFoundException {
        //GIVEN a price request with date 2020-06-15 16:00:00
        LocalDateTime applicationDate = LocalDateTime.parse("2020-06-15 16:00:00", formatter);
        jobRequestDto.setApplicationDate(applicationDate);

        // WHEN the price is requested
        ResponseDto<PriceController.PriceResponse> response = priceController.getPrices(jobRequestDto);

        // THEN expected price is returned
        assertThat(response.getData().productId).isEqualTo(PRODUCT_ID);
        assertThat(response.getData().brandId).isEqualTo(BRAND_ID);
        assertThat(response.getData().currency).isEqualTo(CURRENCY_EUR);
        assertThat(response.getData().applicationDate).isEqualTo(applicationDate);
        assertThat(response.getData().price).isEqualTo(38.95f);

    }

    @Test(expected = PriceNotFoundException.class)
    public void getPriceNotFound() throws PriceNotFoundException {
        //GIVEN a price request with date 2020-06-15 16:00:00
        LocalDateTime applicationDate = LocalDateTime.parse("2018-06-15 16:00:00", formatter);
        jobRequestDto.setApplicationDate(applicationDate);

        // WHEN the price is requested
        ResponseDto<PriceController.PriceResponse> response = priceController.getPrices(jobRequestDto);

        // THEN expected exception is thrown
    }

}
