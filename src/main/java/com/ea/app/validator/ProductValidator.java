package com.ea.app.validator;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ea.app.model.Product;
import com.ea.app.service.IProductService;
import com.ea.app.util.ProductUtil;

@Component
public class ProductValidator implements Validator{

	@Autowired
	private ProductUtil util;
	@Autowired
	private IProductService service;

	@Override
	public boolean supports(Class<?> clazz) {
		return Product.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		Product products=(Product)target;
		if(!util.getStoresUtil().contains(products.getStoreName())){
			errors.rejectValue("storeName", "", "Please choose valid StoreName");
		}
		if(!Pattern.compile("[A-Z]{4,8}").matcher(products.getProdNotes()).matches()){
			errors.rejectValue("prodNotes", "", "Enter 4-8 Uppercase letters only");
		}
		if(!Pattern.compile("[a-zA-Z]{10,250}").matcher(products.getProdDesc()).matches()){
			errors.rejectValue("prodDesc", "", "Chars only 10 to 250 accepted");
		}

	}

}