package com.app.dto;

import java.time.LocalDate;

import com.app.entity.Category;

import lombok.Data;

@Data
public class AddProductDto {
	private String productName;
	private String productCode;
	private LocalDate dateOfManufacturing;
	private Category category;
	
	//all fields in the DTO class and entity class must be same
}
