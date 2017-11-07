package com.project.license.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.license.models.License;
import com.project.license.models.Person;
import com.project.license.services.LService;
import com.project.license.services.PService;

@Controller
public class Main {

	private PService pservice;
	private LService lservice;
	public Main(PService pservice, LService lservice) {
		this.pservice = pservice;
		this.lservice = lservice;
	}
	
	@RequestMapping("/persons/new")
	public String newPerson(@ModelAttribute("person") Person person) {
		return "newPerson";
	}
	
	@PostMapping("/persons/new")
	public String addPerson(
		@Valid @ModelAttribute("person") Person person,
		BindingResult res) {
		
		if (res.hasErrors()) {
			return "newPerson";
		} else {
			pservice.addPerson(person);
			return "redirect:/persons/new";
		}
	}
	
	@RequestMapping("persons/{id}")
	public String getPerson(Model model, @PathVariable("id") Long id) {
		model.addAttribute("person", pservice.getPerson(id));
		model.addAttribute("license", lservice.getLicense(id));
		return "person";
	}
	
	@RequestMapping("/licenses/new")
	public String newLicense(Model model,
		@ModelAttribute("license") License license) {
		
		List<Person> people = pservice.getAll();
		model.addAttribute("people", people);
		
		return "newLicense";
	}
	
	@PostMapping("licenses/new")
	public String addLicense(
		@Valid @ModelAttribute("license") License license,
		BindingResult res, Model model) {
			
		if (res.hasErrors()) {
			List<Person> people = pservice.getAll();
			model.addAttribute("people", people);
			return "newLicense";
		} else {
			lservice.addLicense(license);
			return "redirect:/licenses/new";
		}
	}
	
}
