package com.project.ninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.ninjas.models.Dojo;
import com.project.ninjas.models.Ninja;
import com.project.ninjas.services.CDService;

@Controller
public class Ninjas {

	private CDService service;
	public Ninjas(CDService service) {
		this.service = service;
	}
	
	@RequestMapping("/")
	public String index(Model model,
		@ModelAttribute("ninja") Ninja ninja,
		@ModelAttribute("dojo") Dojo dojo) {
		
		List<Dojo> dojos = service.getDojos();
		model.addAttribute("dojos", dojos);
		
		List<Ninja> ninjas = service.getNinjas();
		model.addAttribute("ninjas", ninjas);
		
		return "index";
	}
	
	@PostMapping("/dojos/new")
	public String addDojo(
		@Valid @ModelAttribute("dojo") Dojo dojo,
		BindingResult res) {
		
		if (res.hasErrors()) {
			return "index";
		} else {
			service.addDojo(dojo);
			return "redirect:/";
		}
	}
	
	@PostMapping("/ninjas/new")
	public String addNinja(
		@Valid @ModelAttribute("ninja") Ninja ninja,
		BindingResult res) {
		
		if (res.hasErrors()) {
			return "index";
		} else {
			service.addNinja(ninja);
			return "redirect:/";
		}
	}

}
