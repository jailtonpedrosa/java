package com.adm.sales.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adm.sales.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
