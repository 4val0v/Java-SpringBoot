package com.codingdojo.hellohuman.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/") // all paths will be mapped from this path
public class HomeController {
	
	// GET method is implied, but here's how it looks when invoked
	@RequestMapping(path="", method=RequestMethod.GET)
	public String index(Model model, @RequestParam(value="name", required=false) String q) {
		if (q == null) {
			q = "Human";
		}
		model.addAttribute("name", q);
		return "index";
	}
	
}