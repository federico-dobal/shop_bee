package com.company.price.controller;

import com.company.price.dto.ResponseDto;
import com.company.price.entity.Price;
import com.company.price.exceptions.PriceNotFoundException;
import com.company.price.service.PriceService;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(path = "/price")
@RequiredArgsConstructor
public class PriceController {

    private final PriceService priceService;

    @GetMapping(path = "/")
    @ResponseBody
    public ResponseDto<PriceResponse> getPrices(@RequestBody @Valid RequestPriceRequestDto dto) throws PriceNotFoundException {
        Price priceFromDb = priceService.getPriceForApplicationDate(dto.applicationDate, dto.productId, dto.brandId);
        return ResponseDto.<PriceResponse>builder()
                .data(PriceResponse.builder()
                        .productId(priceFromDb.getProductId())
                        .brandId(priceFromDb.getBrandId())
                        .priceList(priceFromDb.getPriceList())
                        .applicationDate(dto.applicationDate)
                        .price(priceFromDb.getPrice())
                        .currency(priceFromDb.getCurrency())
                        .build())
                .build();
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    protected static class RequestPriceRequestDto {

        @NotNull
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        private LocalDateTime applicationDate;

        @NotNull
        private Integer   productId;

        @NotNull
        private Integer   brandId;
    }

    @Builder
    @Data
    protected static class GetPricesResponse {
        List<PriceResponse> prices;
    }

    @Builder
    @Data
    protected static class PriceResponse {
        Integer        productId;
        Integer        brandId;
        Integer        priceList;
        LocalDateTime  applicationDate;
        Float          price;
        String         currency;
    }
}
