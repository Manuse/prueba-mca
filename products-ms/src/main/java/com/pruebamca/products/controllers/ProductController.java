package com.pruebamca.products.controllers;

import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.pruebamca.products.api.ProductApi;
import com.pruebamca.products.dto.ProductDetailDTO;
import com.pruebamca.products.services.ProductService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ProductController implements ProductApi {

	private final ProductService productService;
	
	@Override
	public ResponseEntity<Set<ProductDetailDTO>> getProductSimilar(String productId) {
		log.info("Get products similar to product: " + productId);
		return ResponseEntity.ok(productService.getProductSimilar(productId));
	}

}
