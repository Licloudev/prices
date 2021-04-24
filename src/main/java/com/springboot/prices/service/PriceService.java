package com.springboot.prices.service;

import com.springboot.prices.dto.PriceDTO;
import com.springboot.prices.mapper.PriceMapper;
import com.springboot.prices.model.Price;
import com.springboot.prices.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PriceService {
    @Autowired
    PriceRepository priceRepository;

    public PriceDTO getPriceById(int id) {
        Optional<Price> price = priceRepository.findById(id);
        return price.map(PriceMapper.INSTANCE::priceToPriceDTO).orElse(null);
    }

    public List<PriceDTO> getPricesByParams(LocalDateTime applicationDate, int productId, int brandId) {
        List<PriceDTO> prices = new ArrayList<>();
        priceRepository.getListPrices(applicationDate, productId, brandId)
                .forEach(price -> prices.add(PriceMapper.INSTANCE.priceToPriceDTO(price)));
        return prices;
    }

    public List<PriceDTO> getAllPrices() {
        List<PriceDTO> prices = new ArrayList<>();
        priceRepository.findAll()
                .forEach(price -> prices.add(PriceMapper.INSTANCE.priceToPriceDTO(price)));
        return prices;
    }

}
