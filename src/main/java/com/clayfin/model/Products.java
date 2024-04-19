package com.clayfin.model;

import com.clayfin.common.util.AbstractClass;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "PRODUCTS")
@Data
public class Products extends AbstractClass  { 
	
	
	@Column(name = "PRODUCT_NAME")
	private String name;
	
	private String discription;
	
	private String summary;
	
	@JsonIgnore
	private Double price;
	
//	@ElementCollection
//	private List<String> tax;
	
	private Boolean productAvailability;
	
	@ManyToOne
	private Category  category;
	
	@Lob
	private String productImg;

	private String packing;
	
	private String productCode;
	private String Barcode;
	private String Weight;
	private String volume;
	
	@ManyToOne
	private Cart cart;
	
	@JsonIgnore
	@OneToOne
	private Discount discount;
	
	private Double quantityMax;
	
	private Double quantityMin;
	
//	@OneToOne
//	@JsonIgnore
//	private Price price;
	
	
}
