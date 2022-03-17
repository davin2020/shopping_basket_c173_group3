package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
public class OrderLine {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;		
	private int prodId;
	private int orderId;
	private String prodName;
	private float price;
	private int quantity;
	//private int quantityAvaiable;
	private int typeId;
}
