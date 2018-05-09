package com.ea.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

import com.ea.app.service.impl.ProductServiceImpl;


public class TestSerice {

	@Test
	public void test() {
		ProductServiceImpl service=null;
		
		service=new ProductServiceImpl();
		assertNotNull("ProductService is not null", service);
	}
	
	@After
	public void nullify(){
		ProductServiceImpl service=null;
	}

}
