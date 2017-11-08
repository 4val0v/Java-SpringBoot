package com.project.products.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.project.products.models.Category;
import com.project.products.models.Product;
import com.project.products.repositories.CategoryRepo;
import com.project.products.repositories.ProductRepo;

@Service
public class Store {

	private CategoryRepo catRepo;
	private ProductRepo prodRepo;
	
	public Store(CategoryRepo cat, ProductRepo prod) {
		this.catRepo = cat;
		this.prodRepo = prod;
	}
	
	public List<Category> getCategories() {
		return catRepo.findAll();
	}
	
	public List<Category> listAvailCategories(Product product) {
		List<String> names = new ArrayList<String>();
		List<Category> current = product.getCategories();
		
		if (current.isEmpty()) {
			names.add("");
		} else {
			for (Category c: current) {
				names.add(c.getName());
			}
		}
		List<Category> categories = catRepo.findByNameNotIn(names);
		return categories;
	}
	
	public Category getCategory(Long id) {
		return catRepo.findOne(id);
	}
	
	public void addCategory(Category category) {
		catRepo.save(category);
	}
	
	public List<Product> getProducts() {
		return prodRepo.findAll();
	}
	
	public List<Product> listAvailProducts(Category category) {
		List<String> names = new ArrayList<String>();
		List<Product> current = category.getProducts();
		
		if (current.isEmpty()) {
			names.add("");
		} else {
			for (Product c: current) {
				names.add(c.getName());
			}
		}
		List<Product> products = prodRepo.findByNameNotIn(names);
		return products;
	}
	
	public Product getProduct(Long id) {
		return prodRepo.findOne(id);
	}
	
	public void addProduct(Product product) {
		prodRepo.save(product);
	}
	
}
