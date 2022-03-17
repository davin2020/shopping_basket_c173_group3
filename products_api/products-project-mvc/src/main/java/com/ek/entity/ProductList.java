package com.ek.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.ek.entity.*;

@NoArgsConstructor
@AllArgsConstructor
public class ProductList {
	
	@Setter
	@Getter
	List <Product> prodList;

}
