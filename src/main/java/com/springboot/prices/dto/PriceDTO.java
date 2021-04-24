package com.springboot.prices.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;

@ApiModel("Price")
public class PriceDTO {

    private int id;

    @ApiModelProperty(value = "brandId", example = "1")
    private BrandDTO brandId;

    @ApiModelProperty(value = "startDate", example = "2020-06-14-00.00.00")
    private LocalDate startDate;

    @ApiModelProperty(value = "endDate", example = "2020-12-31-23.59.59")
    private LocalDate endDate;

    @ApiModelProperty(value = "priceList", example = "1")
    private int priceList;

    @ApiModelProperty(value = "productId", example = "35455")
    private int productId;

    @ApiModelProperty(value = "priority", example = "0")
    private int priority;

    @ApiModelProperty(value = "price", example = "35.50")
    private long price;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BrandDTO getBrandId() {
        return brandId;
    }

    public void setBrandId(BrandDTO brandId) {
        this.brandId = brandId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getPriceList() {
        return priceList;
    }

    public void setPriceList(int priceList) {
        this.priceList = priceList;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
