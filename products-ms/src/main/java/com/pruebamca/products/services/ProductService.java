package com.pruebamca.products.services;

import java.util.Set;

import com.pruebamca.products.dto.ProductDetailDTO;

public interface ProductService {

	Set<ProductDetailDTO> getProductSimilar(String productId);
	
}
