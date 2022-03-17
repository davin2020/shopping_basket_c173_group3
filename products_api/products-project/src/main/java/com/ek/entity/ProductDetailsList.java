package com.ek.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class ProductDetailsList {
	
	@Setter
	@Getter
	List <ProductDetails> productDetailsList;
}

