package com.springboot.prices.controller;

import com.springboot.prices.dto.PriceDTO;
import com.springboot.prices.service.PriceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@Api(value = "Price Controller")
public class PriceController {

    @Autowired
    PriceService priceService;

    @ApiOperation(value = "GET price by id", response = PriceDTO.class)
    @GetMapping(value = "/price/{id}")
    public ResponseEntity<PriceDTO> getPrice(@PathVariable("id") int id) {
        return Optional
                .ofNullable(priceService.getPriceById(id))
                .map(price -> ResponseEntity.ok().body(price))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @ApiOperation(value = "GET price by parameters", response = Iterable.class)
    @GetMapping(value = "/price")
    public ResponseEntity<List<PriceDTO>> getPricesByParams(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd-HH.mm.ss") LocalDateTime applicationDate,
                                                            @RequestParam("productId") int productId,
                                                            @RequestParam("brandId") int brandId) {
        return ResponseEntity.ok(priceService.getPricesByParams(applicationDate, productId, brandId));
    }

    @ApiOperation(value = "GET all prices", response = Iterable.class)
    @GetMapping(value = "/prices")
    public ResponseEntity<List<PriceDTO>> getAllPrices() {
        return ResponseEntity.ok(priceService.getAllPrices());
    }
}
