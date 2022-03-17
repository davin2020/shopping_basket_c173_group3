package com.ek.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class ProductDetails {
	@Setter
	@Getter
	private Product prod;
	
	@Setter
	@Getter
	private Type type;
}
