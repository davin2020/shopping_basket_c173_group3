package com.ek.entity;


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
public class Type {
	
	@Setter
	@Getter
	private int typeId;
	
	@Setter
	@Getter
	private String typeName;
	
	@Setter
	@Getter
	private double taxPercentage;

}
