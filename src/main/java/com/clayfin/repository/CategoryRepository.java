package com.clayfin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clayfin.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
