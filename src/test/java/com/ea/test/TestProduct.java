package com.ea.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

import com.ea.app.model.Product;

public class TestProduct {

	@Test
	public void test() {
		Product product=null;
		
		product=new Product();
		assertNotNull("Product is not null", product);
	}
	
	@After
	public void nullify(){
		Product product=null;
	}

}
