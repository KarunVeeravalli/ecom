package com.clayfin.model;

import java.util.List;

import com.clayfin.common.util.AbstractClass;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Cart extends AbstractClass{
	
	@OneToMany(mappedBy = "cart")
	private List<Products> products;
}
