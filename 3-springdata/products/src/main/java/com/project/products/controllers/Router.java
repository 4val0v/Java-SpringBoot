package com.project.products.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.products.models.Category;
import com.project.products.models.Product;
import com.project.products.services.Store;

@Controller
public class Router {

	private Store store;
	public Router(Store store) {
		this.store = store;
	}
	
	@RequestMapping("/")
	public String index(Model model,
		@ModelAttribute("product") Product product,
		@ModelAttribute("category") Category category) {
		
		model.addAttribute("categories", store.getCategories());
		model.addAttribute("products", store.getProducts());
		
		return "index";
	}
	
	@RequestMapping("/products/{id}")
	public String showProd(Model model,
		@PathVariable("id") Long id) {
		
		model.addAttribute("product", store.getProduct(id));
		model.addAttribute("categories", store.getCategories());
		
		return "showProd";
	}
	
	@RequestMapping("/categories/{id}")
	public String showCat(Model model,
		@PathVariable("id") Long id) {
		
		model.addAttribute("category", store.getCategory(id));
		model.addAttribute("products", store.getProducts());
		
		return "showCat";
	}
	
	@PostMapping("/products/new")
	public String addProd(Model model,
		@ModelAttribute("category") Category category, @Valid 
		@ModelAttribute("product") Product product, BindingResult res) {
		
		if (res.hasErrors()) {
			List<Category> categories = store.getCategories();
			model.addAttribute("categories", categories);
			List<Product> products = store.getProducts();
			model.addAttribute("products", products);
			return "index";
			
		} else {
			store.addProduct(product);
			return "redirect:/";
		}
	}
	
	@PostMapping("/categories/new")
	public String addCat(Model model,
		@ModelAttribute("product") Product product, @Valid 
		@ModelAttribute("category") Category category, BindingResult res) {
		
		if (res.hasErrors()) {
			List<Category> categories = store.getCategories();
			model.addAttribute("categories", categories);
			List<Product> products = store.getProducts();
			model.addAttribute("products", products);
			return "index";
			
		} else {
			store.addCategory(category);
			return "redirect:/";
		}
	}
	
	@PostMapping("/products/{pid}/add")
	public String setProdCat(Model model,
		@PathVariable("pid") Long pid,
		@RequestParam("category") Long cid) {

		Product product = store.getProduct(pid);
		Category category = store.getCategory(cid);
		product.getCategories().add(category);
		store.addProduct(product);
			
		return "redirect:/products/".concat(pid.toString());
	}
	
}



