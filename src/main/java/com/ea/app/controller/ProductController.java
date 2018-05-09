package com.ea.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ea.app.model.Product;
import com.ea.app.service.IProductService;
import com.ea.app.spec.ProductSpecification;
import com.ea.app.util.ProductUtil;
import com.ea.app.validator.ProductValidator;

@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private IProductService service;
	@Autowired
	private ProductValidator validator;
	@Autowired
	private ProductUtil util;

	//1. show Register Page
	@GetMapping("/show")
	public String showProdsPage(ModelMap map){
		//modeAttribute/form backing object
		map.addAttribute("storeNames",util.getStoresUtil());
		map.addAttribute("products",new Product());
		return "prodPriceEntry";
	}

	//2. save data to DB
	@PostMapping("/show")
	public String saveData(@ModelAttribute("products") Product products,Errors errors,ModelMap map){
		//before save do validation
		validator.validate(products, errors);
		if(!errors.hasErrors())
		{
			Long prodId=service.save(products);
			//clear form after save..
			map.addAttribute("products",new Product());
			//send message to UI after save
			map.addAttribute("message", "Price Entered for prodId: "+prodId);
		}
		map.addAttribute("storeNames",util.getStoresUtil());
		return "prodPriceEntry";
	}

	//3. Get Data from DB
	@GetMapping("/all")
	public String getAllRecords(@PageableDefault(size=4,sort="prodId",direction=Direction.DESC)Pageable pageable,@ModelAttribute Product products,ModelMap map){
		ProductSpecification spec=new ProductSpecification(products);
		Page<Product> page=service.findAll(spec,pageable);
		map.addAttribute("page", page);
		map.addAttribute("products", products);
		map.addAttribute("uomTypes",util.getStoresUtil());
		return "productData";
	}

	//4.delete product by Id.
	@GetMapping("/delete")
	public String delete(@RequestParam Long prodId){
		service.delete(prodId);
		return "redirect:all";
	}

	@GetMapping("/details")
	public String idealPrice(ModelMap map){
		String msg=null;
	    msg= service.getIdlPrice(); 
	    map.addAttribute("message", msg);
	    return "ProdDetails";
	}

}
