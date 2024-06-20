package com.app.dto;

import java.time.LocalDate;

import com.app.entity.Category;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

@Data
public class UpdateProductDto {
	@JsonProperty(access = Access.WRITE_ONLY)
	private int productId;
	private String productName;
	private String productCode;
	private LocalDate dateOfManufacturing;
	private Category category;
}
