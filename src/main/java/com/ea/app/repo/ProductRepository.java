package com.ea.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ea.app.model.Product;
/**
 * @author Amit
 * UOM Data Access Layer 
 */
public interface ProductRepository extends JpaRepository<Product, Long>,JpaSpecificationExecutor<Product>{

}
