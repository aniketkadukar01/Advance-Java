package com.app.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name="products")
@Data
public class Product {
	
	@JsonIgnore // it will ignore the particular field at the time of input
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private int productId;
	
	
	@NotBlank(message = "Name is mandatory") //not blank is specially check for string
	@Column(name="product_name",nullable = false)
	private String productName;
	
	
	@NotBlank(message = "Product code is mandatory")//Application level constraints
	@Column(name="product_code",unique = true , nullable = false)//database level constraints
	private String productCode;
	
	
	@NotNull(message = "Date of manufacturing is mandatory") //not null is applicable for all type 
	@Column(name="date_of_manufacturing")
	private LocalDate dateOfManufacturing;
	
	
	@Enumerated(EnumType.STRING)
	@NotNull(message = "Category is mandatory")
	@Column(name="categories")
	private Category category;
}
