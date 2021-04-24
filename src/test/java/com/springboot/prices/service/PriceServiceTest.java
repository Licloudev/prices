package com.springboot.prices.service;

import com.springboot.prices.dto.PriceDTO;
import com.springboot.prices.model.Brand;
import com.springboot.prices.model.Price;
import com.springboot.prices.repository.PriceRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

public class PriceServiceTest {

    @InjectMocks
    private PriceService priceService;

    @Mock
    private PriceRepository priceRepository;

    @Before
    public void inicializaMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldGetPricesById(){
        Price price = createPrice(1);
        when(priceRepository.findById(1)).thenReturn(Optional.of(price));

        PriceDTO priceDTO = priceService.getPriceById(1);

        Assert.assertNotNull(priceDTO);
        Assert.assertEquals(price.getId(), priceDTO.getId());
    }

    @Test
    public void shouldGetPricesByParams(){
        LocalDate now = LocalDate.now();
        int productId = 35455;
        int brandId = 1;
        when(priceRepository.getListPrices(now, productId, brandId)).thenReturn(getPrices());

        List<PriceDTO> priceDTOS = priceService.getPricesByParams(now, productId,brandId);

        Assert.assertNotNull(priceDTOS);
        priceDTOS.forEach(priceDTO -> {
            Assert.assertEquals(productId, priceDTO.getProductId());
            Assert.assertEquals(brandId, priceDTO.getBrandId().getId());
        });
    }

    private List<Price> getPrices(){
        List<Price> prices = new ArrayList<>();

        prices.add(createPrice(1));
        prices.add(createPrice(2));
        prices.add(createPrice(3));

        return prices;
    }

    private Price createPrice(int id){
        Price price = new Price();

        price.setId(id);
        price.setPrice(35.50);
        price.setPriceList(1);
        price.setCurrency("EUR");
        price.setProductId(35455);
        price.setPriority(1);
        price.setBrandId(createBrand());
        price.setStartDate(LocalDate.now());
        price.setEndDate(LocalDate.now());

        return price;
    }

    private Brand createBrand(){
        Brand brand = new Brand();
        brand.setId(1);
        brand.setName("ZARA");
        return brand;
    }
}
