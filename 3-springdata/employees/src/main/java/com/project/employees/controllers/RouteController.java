package com.project.employees.controllers;

import java.util.ArrayList;
import java.util.Arrays;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.employees.models.Employee;
import com.project.employees.services.HR;

@Controller
public class RouteController{

	private HR hr;
	public RouteController(HR hr){ this.hr = hr; }
	
	@RequestMapping("/")
	public String index(Model m){
		m.addAttribute("all", hr.all());
		m.addAttribute("managers", hr.managers());
		m.addAttribute("employees", hr.employees());
		return "index";
	}
	
	@RequestMapping("/employee/{e}")
	public String employee(Model m,
		@PathVariable("e") Long e){
		
		// if manager, redirect to manager page
		if (hr.get(e).isPromoted()) {
			return "redirect:/manager/".concat(e.toString());
		} else {
			m.addAttribute("employee", hr.get(e));
		}
		return "employee";
	}
	
	@RequestMapping("/manager/{ma}")
	public String manager(Model m,
		@PathVariable("ma") Long ma){
		m.addAttribute("manager", hr.get(ma));
		m.addAttribute("team", hr.team(hr.get(ma)));
		return "manager";
	}
	
	@RequestMapping("/admin")
	public String admin(Model m,
		@ModelAttribute("employee") Employee e) {
		m.addAttribute("employees", hr.employees());
		return "admin";
	}
	
	@PostMapping("/admin/add")
	public String add(
		@Valid @ModelAttribute("employee") Employee e,
		BindingResult r, RedirectAttributes f) {
		
		if (r.hasErrors()) {
			f.addFlashAttribute(
				"name", "Employee name must be 3 characters minimum.");
		} else {
			hr.create(e);
		}
		return "redirect:/admin";
	}
	
	@PostMapping("/admin/promote")
	public String promote(
		@RequestParam("m_id") String m_id,
		@RequestParam("e_ids") String ids) {
		
		Employee m = hr.get(Long.parseLong(m_id));
		hr.promote(m);
		
		List<String> string_ids = Arrays.asList(ids.split(","));
		List<Employee> es = new ArrayList<Employee>();
		for (String s : string_ids) {
			Employee e = hr.get(Long.parseLong(s));
			hr.assign(e, m);
		}
		
		return "redirect:/admin";
	}
	
}
