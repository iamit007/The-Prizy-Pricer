package com.ea.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

import com.ea.app.model.Product;
import com.ea.app.util.ProductUtil;

public class TestUtil {

	@Test
	public void test() {
		ProductUtil util=null;
		
		util=new ProductUtil();
		assertNotNull("ProductUtil is not null", util);
	}
	
	@After
	public void nullify(){
		ProductUtil util=null;
	}

}
