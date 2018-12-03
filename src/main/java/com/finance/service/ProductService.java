package com.finance.service;

import java.util.List;

import com.finance.model.Period;
import com.finance.model.Product;

public interface ProductService {
	List<Product> getProducts();
	List<Product> getCategoryProducts(int id);
	List<Period> getPeriod1();
}
