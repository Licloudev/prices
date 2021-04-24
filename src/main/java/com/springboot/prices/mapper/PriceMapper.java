package com.springboot.prices.mapper;

import com.springboot.prices.dto.BrandDTO;
import com.springboot.prices.dto.PriceDTO;
import com.springboot.prices.model.Brand;
import com.springboot.prices.model.Price;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PriceMapper {
    PriceMapper INSTANCE = Mappers.getMapper(PriceMapper.class);

    @Mapping(target = "brandId", source = "brandId.id")
    PriceDTO priceToPriceDTO(Price price);

    BrandDTO brandToBrandDTO(Brand brand);

}
