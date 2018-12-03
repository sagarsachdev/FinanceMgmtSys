package com.finance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finance.dao.ProductDao;
import com.finance.model.Period;
import com.finance.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao pdao;
	
	public List<Product> getProducts() {
		return pdao.getProducts();
	}

	public List<Product> getCategoryProducts(int id) {
		return pdao.getCategoryProducts(id);
	}

	public List<Period> getPeriod1() {
		return pdao.getPeriod1();
	}

}
