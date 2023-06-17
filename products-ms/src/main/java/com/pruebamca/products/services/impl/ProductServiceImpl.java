package com.pruebamca.products.services.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.pruebamca.products.dto.ProductDetailDTO;
import com.pruebamca.products.mapper.ProductMapper;
import com.pruebamca.products.rest.clients.SimulateClient;
import com.pruebamca.products.services.ProductService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

	private final SimulateClient simulateClient;
	
	private final ProductMapper productMapper;

	@Override
	@Cacheable("products")
	public Set<ProductDetailDTO> getProductSimilar(String productId) {
		
		List<String> productsSimilarList = simulateClient.getProductSimilarids(productId);
		
		log.info("Products similars: " + productsSimilarList);
		
		return productsSimilarList.stream()
				.map(p -> productMapper.toProductDetailDTO(simulateClient.getProduct(p)))
				.collect(Collectors.toSet());
		
	}
	
}
