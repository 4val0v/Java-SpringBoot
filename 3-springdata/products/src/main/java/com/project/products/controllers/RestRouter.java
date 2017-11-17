package com.project.products.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.products.repositories.ProductRepo;
import com.project.products.models.Product;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestRouter {

	private ProductRepo repo;
	public RestRouter(ProductRepo repo) {
		this.repo = repo;
	}

	@RequestMapping(path="/get", method= RequestMethod.GET)
	public List<Product> getProducts(){
		List<Product> allproducts = repo.findAll();
		return allproducts;
	}

}



