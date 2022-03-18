package com.xyz.back.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Product")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@XmlRootElement
public class Product {
	
	@Setter
	@Getter
	@Id
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
