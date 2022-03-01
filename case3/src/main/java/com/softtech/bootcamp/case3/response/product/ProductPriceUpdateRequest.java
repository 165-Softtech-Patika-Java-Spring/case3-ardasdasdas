package com.softtech.bootcamp.case3.response.product;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductPriceUpdateRequest {

    Long id;
    BigDecimal price;
}
