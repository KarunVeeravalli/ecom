package com.clayfin.model;

import com.clayfin.common.util.AbstractClass;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Discount extends AbstractClass{
	
	private Double discountPer;
	
	@OneToOne
	private Products product;
	
	@OneToOne
	private Orders orders;
}
