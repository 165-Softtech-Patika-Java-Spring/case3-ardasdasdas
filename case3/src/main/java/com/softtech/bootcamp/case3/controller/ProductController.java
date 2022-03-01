package com.softtech.bootcamp.case3.controller;

import com.softtech.bootcamp.case3.response.RestResponse;
import com.softtech.bootcamp.case3.response.product.ProductPriceUpdateRequest;
import com.softtech.bootcamp.case3.response.product.ProductSaveRequest;
import com.softtech.bootcamp.case3.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    ResponseEntity save(@RequestBody ProductSaveRequest productSaveRequest){
        return ResponseEntity.ok(RestResponse.of(productService.save(productSaveRequest)));
    }

    @GetMapping
    public ResponseEntity list(){
        return ResponseEntity.ok(RestResponse.of(productService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        return ResponseEntity.ok(RestResponse.of(productService.findById(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Long id){
        return ResponseEntity.ok(RestResponse.of(productService.deleteById(id)));
    }

    @PatchMapping
    public ResponseEntity updatePrice(@RequestBody ProductPriceUpdateRequest productPriceUpdateRequest){
        return ResponseEntity.ok(RestResponse.of(productService.updatePrice(productPriceUpdateRequest)));
    }
}
