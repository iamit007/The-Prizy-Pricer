package com.ea.app.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.ea.app.model.Product;
import com.ea.app.repo.ProductRepository;
import com.ea.app.service.IProductService;


@Service
public class ProductServiceImpl implements IProductService{

	@Autowired
	private ProductRepository repo;

	@Override
	public Long save(Product products){
		products=repo.save(products);
		return products.getProdId();
	}

	@Override
	public void delete(Long prodId) {
		repo.delete(prodId);
	}

	@Override
	public Page<Product> findAll(Specification<Product> spec, Pageable pageable) {
		return repo.findAll(spec, pageable);
	}

	@Override
	public List<Double> getAllPrice() {

		List<Product> prodList=null;
		Product product=null;
		List<Double> priceList1=null;

		prodList=new ArrayList<Product>();
		product=new Product();
		priceList1=new ArrayList<Double>();

		for (int i = 0; i < prodList.size(); i++) {
			Double priceList=product.getProdPrice();
			priceList1.add(priceList);
		}
		return priceList1;
	}

	@Override
	public String logicIdlPrice() {

		List<Double> crntPriceList=null;
		int totPrices=0,count=0;
		Double lPrice=0.0,hPrice=0.0,avgPrice=0.0,idlPrice=0.0,sumPrices=0.0;

		crntPriceList=getAllPrice();
		totPrices=crntPriceList.size();
		lPrice=crntPriceList.get(0);

		Collections.sort(crntPriceList);

		crntPriceList.remove(0);
		crntPriceList.remove(0);

		Collections.reverse(crntPriceList);

		hPrice=crntPriceList.get(0);
		crntPriceList.remove(0);
		crntPriceList.remove(0);

		ListIterator< Double> litr=crntPriceList.listIterator();

		while (litr.hasNext()) {
			sumPrices=sumPrices+crntPriceList.get(count);
			count++;
		}

		idlPrice=sumPrices+(sumPrices*0.5);
		return "Total Prices " +totPrices+ " Lowest Price " +lPrice+ " Highest Price " +hPrice+ " Average Price " +avgPrice+ " Ideal Price " +idlPrice;
	}

	@Override
	public String getIdlPrice() {
		return logicIdlPrice();
	}

}
