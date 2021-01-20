package com.springdatatwo.productsandcategories.repositories;

import com.springdatatwo.productsandcategories.models.Category;
import com.springdatatwo.productsandcategories.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
    List<Category> findAll();
    List<Category> findByProductsNotContains(Product product);
}
