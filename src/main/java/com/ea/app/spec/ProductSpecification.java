package com.ea.app.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.ea.app.model.Product;


public class ProductSpecification implements Specification<Product>{

	private Product filter;

	public ProductSpecification(Product products) {
		this.filter=products;
	}

	@Override
	public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		Predicate p=cb.conjunction();
		if(!StringUtils.isEmpty(filter.getStoreName())){
			p.getExpressions()
			.add(
					cb.equal(root.get("uomType"), filter.getStoreName())	
					);
		}
		if(!StringUtils.isEmpty(filter.getProdNotes())){
			p.getExpressions()
			.add(
					cb.like(root.get("uomModel").as(String.class), "%"+filter.getProdNotes()+"%")
					);
		}
		if(!StringUtils.isEmpty(filter.getProdDesc())){
			p.getExpressions()
			.add(
					cb.like(root.get("description").as(String.class), "%"+filter.getProdDesc()+"%")
					);
		}
		return p;
	}

}





