package com.softtech.bootcamp.case3.converter;

import com.softtech.bootcamp.case3.model.Product;
import com.softtech.bootcamp.case3.response.product.ProductSaveRequest;
import com.softtech.bootcamp.case3.response.product.ProductResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductResponse toProductResponseFromProduct(Product product);

    Product toProductFromProductSaveRequest(ProductSaveRequest productSaveRequest);

    List<ProductResponse> toProductResponseListFromProductList(List<Product> productList);

}
