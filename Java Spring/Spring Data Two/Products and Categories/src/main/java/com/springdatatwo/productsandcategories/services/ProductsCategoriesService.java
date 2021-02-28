package com.springdatatwo.productsandcategories.services;

import com.springdatatwo.productsandcategories.models.Category;
import com.springdatatwo.productsandcategories.models.Product;
import com.springdatatwo.productsandcategories.repositories.CategoryRepository;
import com.springdatatwo.productsandcategories.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsCategoriesService {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public ProductsCategoriesService(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    public Product createProduct(Product p) {
        return productRepository.save(p);
    }

    public Category createCategory(Category c) {
        return categoryRepository.save(c);
    }

    public List<Product> allProducts() {
        return productRepository.findAll();
    }

    public List<Category> allCategories() {
        return categoryRepository.findAll();
    }

    public List<Product> productsNoCategories(Category c) {
        return productRepository.findByCategoriesNotContains(c);
    }

    public List<Category> categoriesNoProducts(Product p) {
        return categoryRepository.findByProductsNotContains(p);
    }

    public Product findProduct(Long id) {
        Optional<Product> productToFind = productRepository.findById(id);
        if (productToFind.isPresent())
            return productToFind.get();
        return null;
    }

    public Category findCategory(Long id) {
        Optional<Category> categoryToFind = categoryRepository.findById(id);
        if (categoryToFind.isPresent())
            return categoryToFind.get();
        return null;
    }

    public Product updateProduct(Product p) {
        Product productToUpdate = findProduct(p.getId());
        List<Category> categoryList = productToUpdate.getCategories();
        categoryList.addAll(p.getCategories());
        productToUpdate.setCategories(categoryList);
        return productRepository.save(productToUpdate);
    }

    public Category updateCategory(Category c) {
        Category categoryToUpdate = findCategory(c.getId());
        List<Product> productList = categoryToUpdate.getProducts();
        productList.addAll(c.getProducts());
        categoryToUpdate.setProducts(productList);
        return categoryRepository.save(categoryToUpdate);
    }
}
