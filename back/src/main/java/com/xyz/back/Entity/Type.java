package com.xyz.back.Entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Table(name = "Type")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Type {
	
	@Setter
	@Getter
	@Id
	private int typeId;
	
	@Setter
	@Getter
	private String typeName;
	
	@Setter
	@Getter
	private double taxPercentage;

}
