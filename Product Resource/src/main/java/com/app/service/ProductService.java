package com.app.service;

import java.util.List;

import com.app.dto.AddProductDto;
import com.app.dto.UpdateProductDto;
import com.app.entity.Product;

public interface ProductService {

	Product addNewProduct(AddProductDto newProduct);

	List<Product> displayAllProducts();

	Product displayProductsById(int Id);

	String updateProductAllFields(UpdateProductDto updateProduct);

	String deleteProduct(int id);

}
