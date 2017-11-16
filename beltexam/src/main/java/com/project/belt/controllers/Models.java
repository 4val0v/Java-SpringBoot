package com.project.blackbelt.controllers;

import java.security.Principal;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class Models{
	
	private UserService us;
	private ModelService xs;
	public Models(UserService us, ModelService xs){
		this.us = us;
		this.xs = xs;
	}
	
	// Dashboard
	@RequestMapping("/dashboard")
	public String dashboard(Principal p, Model m) {
		m.addAttribute("user", us.findByUsername(p.getName()));
		m.addAttribute("AllModel", xs.getAll());
		m.addAttribute("SomeModel", xs.getAllBy_Var_(var));
		return dash;
	}

	// HTML Post (i.e. to create relationships)
	@PostMapping("/htmlPost")
	public String htmlPost(RedirectAttributes f,
		@RequestParam("id1") Long id1,
		@RequestParam("id2") Long id2) {
		
		if (conditions) {
			// validation logic
			f.addFlashAttribute("key", "value");
		} else {
			// xs.someModelSMethod(us.get(id1), xs.get(id2));
		}
		return "redirect:/htmlForm"
	}

	// JPA Form
	@RequestMapping("/jpaForm")
	public String jpaForm(Model m,
		@ModelAttribute("x") Model x) {
		return "jpaForm";
	}

	// JPA Post
	@PostMapping("/jpaForm") // same as form
	public string jpaPost(@Valid @ModelAttribute("x") Model x,
		BindingResult r, Model m, RedirectAttributes f) {
		if (r.hasErrors()) {
			f.addFlashAttribute("key", "value");
			return "redirect:/jpaForm";
		} else {
			xs.someModelSMethod(x);
			return "redirect:/success";
		}
	}

	// Show Page
	@RequestMapping("/show/{id}")
	public String showModel(Model m, @PathVariable("id") Long id) {
		m.addAttribute("x", xs.get(id));
		return "show";
	}

	// Admin actions (e.g. delete, promote)
	@RequestMapping("/admin/action/{id}")
	public String action(@PathVariable("id") Long id) {
		xs.someModelSMethod(xs.get(id));
		return "redirect:/admin";
	}

	// Search HTML Post
	@PostMapping("/search")
	public String search(@RequestParam("var") String var) {
		return "redirect:/search/".concat(var);
	}

	// Search Results
	@RequestMapping("/search/{var}")
	public String searchResults(Model m, RedirectAttributes f,
		@PathVariable("var") String var) {

		m.addAttribute("var", var); // to display string
		
		if (xs.searchBy_Var_(var).isEmpty()) {
			f.addFlashAttribute("none", "Nothing found!");
			return "redirect:/search
		} else {
			m.addAttribute("results", xs.searchBy_Var_(var));
			return "/search/".concat(var);
		}
	}

	// Parse list from select multiple form for one to manys
	@PostMapping("/AddToList")
	public String AddList(
		@RequestParam("id" Long id,
		@RequestParam("id_list") String id_list) {
		
		List<String> string_list = Arrays.asList(ids.split(","));
		List<Model> x_list = new ArrayList<Model>();
		for (String s : string_list) {
			x_list.add(xs.get(Long.parseLong(s)));
		}
		xs.assignMany(xs.get(id), x_list);
		return "redirect:/success";
	}

}
