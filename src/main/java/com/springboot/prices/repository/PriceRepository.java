package com.springboot.prices.repository;

import com.springboot.prices.model.Price;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PriceRepository extends CrudRepository<Price, Integer> {

    @Query("SELECT r FROM Price r WHERE r.productId = :productId AND r.brandId.id = :brandId AND"
            + " r.startDate <= :applicationDate AND r.endDate >= :applicationDate")
    List<Price> getListPrices(@Param("applicationDate") Date applicationDate,
                              @Param("productId") int productId,
                              @Param("brandId") int brandId);
}
