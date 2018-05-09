package com.ea.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.ea.app.model.Product;

public interface IProductService {

	public Long save(Product products);
	public void delete(Long uomId);	
	public Page<Product> findAll(Specification<Product> spec,Pageable pageable);
	public List<Double> getAllPrice();
	public String logicIdlPrice();
	public String getIdlPrice();

}