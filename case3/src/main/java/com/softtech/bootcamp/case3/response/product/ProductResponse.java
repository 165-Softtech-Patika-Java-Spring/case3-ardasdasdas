package com.softtech.bootcamp.case3.response.product;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductResponse {

    private Long id;
    private String name;
    private BigDecimal price;
}
