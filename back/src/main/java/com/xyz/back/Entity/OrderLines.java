package com.xyz.back.Entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderLines {
	
	//this will be the name of the JSON array returned by API calls
	List<OrderLine> productList;
}
