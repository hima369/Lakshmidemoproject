package com.eval.coronakit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eval.coronakit.exception.RecordNotFoundException;
import com.eval.coronakit.dao.ProductMasterRepository;
import com.eval.coronakit.entity.ProductMaster;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductMasterRepository repository;

	@Override
	public ProductMaster addNewProduct(ProductMaster product) {
		product = repository.save(product);
		return product;
	}

	@Override
	public List<ProductMaster> getAllProducts() {
		List<ProductMaster> productList = repository.findAll();
		return productList;
	}

	@Override
	public ProductMaster deleteProduct(int productId) {
		Optional<ProductMaster> product = repository.findById(productId);

		if (product.isPresent()) {
			repository.deleteById(productId);
			return product.get();
		} else {
			throw new RecordNotFoundException("No product record exist for given id", productId);
		}
	}

	@Override
	public ProductMaster getProductById(int productId) {
		Optional<ProductMaster> product = repository.findById(productId);
		if (product.isPresent()) {
			return product.get();
		} else {
			throw new RecordNotFoundException("No product record exist for given id", productId);
		}
	}

}
