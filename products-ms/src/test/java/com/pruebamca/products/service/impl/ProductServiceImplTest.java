package com.pruebamca.products.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.pruebamca.products.dto.ProductDetailDTO;
import com.pruebamca.products.mapper.ProductMapper;
import com.pruebamca.products.mapper.ProductMapperImpl;
import com.pruebamca.products.rest.clients.SimulateClient;
import com.pruebamca.products.rest.models.simulate.ProductDetail;
import com.pruebamca.products.services.impl.ProductServiceImpl;
@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

	@InjectMocks
	private ProductServiceImpl productServiceImpl;
	
	@Mock
	private SimulateClient simulateClient;
	
	@Spy
	private ProductMapper productMapper = new ProductMapperImpl();
	
	@Test
	void getProductSimilar_returnSetProductDetails_whenIsAllOk() {
		//given
		List<String> productsIdSimilar = Arrays.asList("1");
		ProductDetail productDetail = new ProductDetail()
				.availability(true)
				.id("1")
				.name("name")
				.price(BigDecimal.TEN);
		
		when(simulateClient.getProductSimilarids(anyString())).thenReturn(productsIdSimilar);
		when(simulateClient.getProduct(anyString())).thenReturn(productDetail);
		
		//when
		 Set<ProductDetailDTO> dtoSet = productServiceImpl.getProductSimilar("1");
		 ProductDetailDTO detailDto = dtoSet.toArray(new ProductDetailDTO[0])[0];
		 
		 //then
		 assertThat(detailDto)
		 .matches(e -> productDetail.getAvailability().equals(e.getAvailability()))
		 .matches(e -> productDetail.getName().equals(e.getName()))
		 .matches(e -> productDetail.getId().equals(e.getId()))
		 .matches(e -> productDetail.getPrice().equals(e.getPrice()));
		
	}
}
