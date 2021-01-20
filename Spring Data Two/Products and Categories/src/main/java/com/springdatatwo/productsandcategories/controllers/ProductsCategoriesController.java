package com.springdatatwo.productsandcategories.controllers;

import com.springdatatwo.productsandcategories.models.Category;
import com.springdatatwo.productsandcategories.models.Product;
import com.springdatatwo.productsandcategories.services.ProductsCategoriesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class ProductsCategoriesController {
    private final ProductsCategoriesService productsCategoriesService;

    public ProductsCategoriesController(ProductsCategoriesService productsCategoriesService) {
        this.productsCategoriesService = productsCategoriesService;
    }

    @RequestMapping("/products/new")
    public String displayProductForm(@ModelAttribute ("product") Product product) {
        return "/productsCategories/newProduct.jsp";
    }

    @RequestMapping(value = "/products/new", method = RequestMethod.POST)
    public String addProduct(@Valid @ModelAttribute ("product") Product product, BindingResult result) {
        if (result.hasErrors())
            return "/productsCategories/newProduct.jsp";
        productsCategoriesService.createProduct(product);
        return "redirect:/products/" + product.getId();
    }

    @RequestMapping("/categories/new")
    public String displayCategoryForm(@ModelAttribute ("category") Category category) {
        return "/productsCategories/newCategory.jsp";
    }

    @RequestMapping(value = "/categories/new", method = RequestMethod.POST)
    public String addCategory(@Valid @ModelAttribute ("category") Category category, BindingResult result) {
        if (result.hasErrors())
            return "/productsCategories/newCategory.jsp";
        productsCategoriesService.createCategory(category);
        return "redirect:/categories/" + category.getId();
    }

    @RequestMapping("/products/{id}")
    public String showProduct(@PathVariable ("id") Long id, @ModelAttribute ("productCategory") Product product, Model model){
        model.addAttribute("product", productsCategoriesService.findProduct(id));
        model.addAttribute("categories", productsCategoriesService.allCategories());
        model.addAttribute("categoriesNoProducts", productsCategoriesService.categoriesNoProducts(product));
        return "/productsCategories/productPage.jsp";
    }

    @RequestMapping("/categories/{id}")
    public String showCategory(@PathVariable ("id") Long id, @ModelAttribute ("categoryProduct") Category category, Model model){
        model.addAttribute("category", productsCategoriesService.findCategory(id));
        model.addAttribute("products", productsCategoriesService.allProducts());
        model.addAttribute("productsNoCategories", productsCategoriesService.productsNoCategories(category));
        return "/productsCategories/categoryPage.jsp";
    }

    @RequestMapping(value = "/productAddCategory", method = RequestMethod.POST)
    public String productAddCategory(@Valid@ModelAttribute ("productCategory") Product product, BindingResult result) {
        if (result.hasErrors())
            return "/productsCategories/productPage.jsp";
        Product p =productsCategoriesService.updateProduct(product);
        return "redirect:/products/" + p.getId();
    }

    @RequestMapping(value = "/categoryAddProduct", method = RequestMethod.POST)
    public String categoryAddProduct(@Valid@ModelAttribute ("categoryProduct") Category category, BindingResult result) {
        if (result.hasErrors())
            return "/productsCategories/categoryPage.jsp";
        Category c =productsCategoriesService.updateCategory(category);
        return "redirect:/categories/" + c.getId();
    }
}
