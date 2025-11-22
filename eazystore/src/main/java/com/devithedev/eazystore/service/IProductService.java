package com.devithedev.eazystore.service;

import com.devithedev.eazystore.dto.ProductDto;

import java.util.List;

public interface IProductService {

    List<ProductDto> getProducts();
}
