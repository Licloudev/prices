package com.springboot.prices.mapper;

import com.springboot.prices.dto.PriceDTO;
import com.springboot.prices.model.Price;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PriceMapper {
    PriceMapper INSTANCE = Mappers.getMapper(PriceMapper.class);

    PriceDTO priceToPriceDTO(Price price);

    Price PriceDTOToPrice(PriceDTO priceDTO);
}
