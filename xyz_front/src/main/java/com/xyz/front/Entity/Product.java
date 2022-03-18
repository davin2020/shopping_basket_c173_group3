package com.xyz.front.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Product {
	
	@Setter
	@Getter
	private int prodId;
	
	@Setter
	@Getter
	private String prodName;
	
	@Setter
	@Getter
	private double price;
	
	@Setter
	@Getter
	private int quantityAvailable;
	
	@Setter
	@Getter
	private int typeId;
	
	@Setter
	@Getter
	private String description;

}
