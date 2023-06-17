package com.pruebamca.products.rest.clients;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

import com.pruebamca.products.rest.models.simulate.ProductDetail;

public interface SimulateClient {

	@GetExchange("/product/{productId}/similarids")
	public List<String> getProductSimilarids(@PathVariable String productId);
	
	@GetExchange("/product/{productId}")
	public ProductDetail getProduct(@PathVariable String productId);
	
}
