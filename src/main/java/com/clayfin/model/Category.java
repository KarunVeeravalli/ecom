package com.clayfin.model;

import java.util.List;

import com.clayfin.common.util.AbstractClass;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Entity
@Data
@Table(name = "CATEGORY",
uniqueConstraints = { 
		  @UniqueConstraint(columnNames = "NAME")
//		  @UniqueConstraint(columnNames = "EMAIL") 
		})
public class Category extends AbstractClass{
	
	private String name;
	
	private String description;
	
//	@OneToMany
//	private SubCategory subCategory;
	

    @OneToMany(mappedBy = "category")
	private List<Products> products;
}
