package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AddProductDto;
import com.app.dto.UpdateProductDto;
import com.app.entity.Product;
import com.app.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@PostMapping("/addNewProduct")
	public ResponseEntity<Product> 
	addNewProduct(@Valid @RequestBody AddProductDto newProduct){
		return ResponseEntity.status(HttpStatus.OK)
				.body(productService.addNewProduct(newProduct));
	}
	
	@GetMapping("/displayAllProduct")
	public ResponseEntity<List<Product>> displayAllProduct(){
		return ResponseEntity.status(HttpStatus.OK)
				.body(productService.displayAllProducts());
	}
	
	@GetMapping("/display/{Id}")
	public ResponseEntity<Product> displayProductsById(@PathVariable int Id){
		return ResponseEntity.status(HttpStatus.OK)
				.body(productService.displayProductsById(Id));
	}
	
	@PutMapping("/updateProduct")
	public ResponseEntity<String>
	updateProduct(@Valid @RequestBody UpdateProductDto updateProduct){
		return ResponseEntity.status(HttpStatus.OK)
				.body(productService.updateProductAllFields(updateProduct));
	}
	
	@DeleteMapping("/deleteProduct/{Id}")
	public ResponseEntity<String> deleteProduct(@PathVariable int Id){
		return ResponseEntity.status(HttpStatus.OK)
				.body(productService.deleteProduct(Id));
	}

}
