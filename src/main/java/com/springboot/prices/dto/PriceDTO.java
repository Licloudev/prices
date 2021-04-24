package com.springboot.prices.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("Price")
public class PriceDTO {

    private int id;

    @ApiModelProperty(value = "brandId", example = "1")
    private int brandId;

    @ApiModelProperty(value = "startDate", example = "2020-06-14-00.00.00")
    private Date startDate;

    @ApiModelProperty(value = "endDate", example = "2020-12-31-23.59.59")
    private Date endDate;

    @ApiModelProperty(value = "priceList", example = "1")
    private int priceList;

    @ApiModelProperty(value = "productId", example = "35455")
    private int productId;

    @ApiModelProperty(value = "priority", example = "0")
    private int priority;

    @ApiModelProperty(value = "price", example = "35.50")
    private long price;

}
