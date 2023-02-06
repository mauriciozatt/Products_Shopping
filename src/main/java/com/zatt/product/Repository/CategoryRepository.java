package com.zatt.product.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zatt.product.Model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
