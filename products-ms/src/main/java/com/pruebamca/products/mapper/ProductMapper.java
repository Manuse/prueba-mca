package com.pruebamca.products.mapper;

import org.mapstruct.Mapper;

import com.pruebamca.products.dto.ProductDetailDTO;
import com.pruebamca.products.rest.models.simulate.ProductDetail;

@Mapper
public interface ProductMapper {

	ProductDetailDTO toProductDetailDTO(ProductDetail productDetail);
	
}
