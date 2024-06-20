package com.app.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.ProductNotFoundException;
import com.app.custom_exception.ResourceAlreadyExistsException;
import com.app.dto.AddProductDto;
import com.app.dto.UpdateProductDto;
import com.app.entity.Product;
import com.app.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public Product addNewProduct(AddProductDto newProduct) {
		Product existingProduct = productRepository
				.findByProductCode(newProduct.getProductCode());
		if(existingProduct!=null) {
			throw new ResourceAlreadyExistsException("Product Code is already exists!!!");
		}
		Product product = mapper.map(newProduct, Product.class);
		return productRepository.save(product);
	}

	@Override
	public List<Product> displayAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product displayProductsById(int Id) {
		return productRepository.findById(Id)
				.orElseThrow(() -> new ProductNotFoundException("Product "
						+ "with Id "+ Id + " not found!!!"));
	}

	@Override
	public String updateProductAllFields(UpdateProductDto updateProduct) {
		Product newProduct = productRepository.findById(updateProduct.getProductId())
				.orElseThrow(() -> new ProductNotFoundException("Invalid Id!!!"));
		
		newProduct.setProductName(updateProduct.getProductName());
		newProduct.setProductCode(updateProduct.getProductCode());
		newProduct.setDateOfManufacturing(updateProduct.getDateOfManufacturing());
		newProduct.setCategory(updateProduct.getCategory());
		
		productRepository.save(newProduct);
		return "Product Update Successfully";
	}

	@Override
	public String deleteProduct(int id) {
		Product newProduct = productRepository.findById(id)
				.orElseThrow(() -> new ProductNotFoundException("Invalid Id!!"));
		productRepository.delete(newProduct);
		return "Product deleted sucessfully";
	}
}
