package com.softtech.bootcamp.case3.service;

import com.softtech.bootcamp.case3.converter.ProductMapper;
import com.softtech.bootcamp.case3.enums.errormessage.NotFoundErrorMessage;
import com.softtech.bootcamp.case3.exception.NotFoundException;
import com.softtech.bootcamp.case3.model.Product;
import com.softtech.bootcamp.case3.repository.ProdcutRepository;
import com.softtech.bootcamp.case3.response.product.ProductPriceUpdateRequest;
import com.softtech.bootcamp.case3.response.product.ProductSaveRequest;
import com.softtech.bootcamp.case3.response.product.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProdcutRepository prodcutRepository;

    public ProductResponse save(ProductSaveRequest productSaveRequest) {
        Product product = ProductMapper.INSTANCE.toProductFromProductSaveRequest(productSaveRequest);
        return ProductMapper.INSTANCE.toProductResponseFromProduct(prodcutRepository.save(product));
    }

    public List<ProductResponse> findAll() {
        return ProductMapper.INSTANCE.toProductResponseListFromProductList(prodcutRepository.findAll());
    }

    public ProductResponse findById(Long id) {
        Product product = prodcutRepository.findById(id).orElseThrow(
                () -> new NotFoundException(NotFoundErrorMessage.PRODUCT_NOT_FOUND_ERROR_MESSAGE));
        return ProductMapper.INSTANCE.toProductResponseFromProduct(product);
    }

    public ProductResponse deleteById(Long id) {
        Product product = prodcutRepository.findById(id).orElseThrow(
                () -> new NotFoundException(NotFoundErrorMessage.PRODUCT_NOT_FOUND_ERROR_MESSAGE));
        prodcutRepository.deleteById(id);
        return ProductMapper.INSTANCE.toProductResponseFromProduct(product);
    }

    public ProductResponse updatePrice(ProductPriceUpdateRequest productPriceUpdateRequest) {
        Product product = prodcutRepository.findById(productPriceUpdateRequest.getId()).orElseThrow(
                () -> new NotFoundException(NotFoundErrorMessage.PRODUCT_NOT_FOUND_ERROR_MESSAGE));
        product.setPrice(productPriceUpdateRequest.getPrice());
        return ProductMapper.INSTANCE.toProductResponseFromProduct(prodcutRepository.save(product));
    }
}
