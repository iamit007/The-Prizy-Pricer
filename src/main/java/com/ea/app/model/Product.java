package com.ea.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * @author Amit
 *  This class is a Model class for
 *  Product Module 
 */

@Entity
@Table(name="prod_tab")
@EntityListeners(AuditingEntityListener.class)
public class Product {

	//1. Primary Key
	@Id
	@Column(name="prod_id")
	@GeneratedValue(generator="pr_gen")
	@GenericGenerator(name = "pr_gen", strategy = "increment")
	private Long prodId;


	//2. UI Fileds as Variables
	@Column(name="pr_price")
	private Double prodPrice;
	@Column(name="str_name")
	private String storeName;
	@Column(name="pr_notes")
	private String prodNotes;
	@Column(name="pr_dsc")
	private String prodDesc;
	@Column(name="bc_url")
	private String barCodeUrl;

	//-------constructors and methods ----------

	//1. default const
	public Product() {
		super();
	}
	//2. PK based Param Const
	public Product(Long prodId) {
		super();
		this.prodId = prodId;
	}

	public Product(Double prodPrice, String prodNotes, String prodDesc, String barCodeUrl) {
		super();
		this.prodPrice = prodPrice;
		this.prodNotes = prodNotes;
		this.prodDesc = prodDesc;
		this.barCodeUrl = barCodeUrl;
	}

	//3. set/get method
	//Alt+Shift+S,R (Select All >OK)

	public Long getProdId() {
		return prodId;
	}
	public void setProdId(Long prodId) {
		this.prodId = prodId;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getProdNotes() {
		return prodNotes;
	}
	public void setProdNotes(String prodNotes) {
		this.prodNotes = prodNotes;
	}
	public String getProdDesc() {
		return prodDesc;
	}
	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}
	public String getBarCodeUrl() {
		return barCodeUrl;
	}
	public void setBarCodeUrl(String barCodeUrl) {
		this.barCodeUrl = barCodeUrl;
	}
	public Double getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(Double prodPrice) {
		this.prodPrice = prodPrice;
	}

	// -------- toString mthds ----------//

	@Override
	public String toString() {
		return "Product [prodId=" + prodId + ",  prodPrice=" + prodPrice
				+ ", storeName=" + storeName + ", prodNotes=" + prodNotes
				+ ", prodDesc=" + prodDesc + ", barCodeUrl=" + barCodeUrl + "]";
	}	

}