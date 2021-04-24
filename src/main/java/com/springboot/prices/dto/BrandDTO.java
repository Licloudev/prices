package com.springboot.prices.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("Brand")
public class BrandDTO {

    private int id;
    @ApiModelProperty(value = "name", example = "ZARA")
    private String name;
}
