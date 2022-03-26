package com.xyz.back.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="orders")
public class Order {
	
	@Id
	private int orderId;
	private String customerId;
	private float totalAmount;
	// TODO orderDate should be a Date not an int - else need to convert from epoch time
	private int orderDate;
}
