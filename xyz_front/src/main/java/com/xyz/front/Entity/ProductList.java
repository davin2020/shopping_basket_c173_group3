package com.xyz.front.Entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@NoArgsConstructor
@AllArgsConstructor
public class ProductList {
	
	@Setter
	@Getter
	List <Product> prodList;

}
