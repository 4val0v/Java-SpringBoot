package com.project.auth.controllers;

import java.security.Principal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.auth.models.User;
import com.project.auth.services.UserService;
import com.project.auth.validators.UserValidator;

@Controller
public class Users {
	
	private UserService us;
	private UserValidator uv;
	public Users (UserService us, UserValidator uv) {
		this.us = us;
		this.uv = uv;
	}
	
	@RequestMapping("/")
	public String landing(Model m, @Valid @ModelAttribute("user") User u,
		@RequestParam(value="error", required=false) String e,
		@RequestParam(value="logout", required=false) String l) {
		
		if (e != null) {
			m.addAttribute("error", "Invalid credentials. Please try again.");
		}
		if (l != null) {
			m.addAttribute("logout", "Thanks for visiting the site!");
		}
		
		return "landing";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User u,
		BindingResult r, Model m, HttpSession s) {
		
		uv.validate(u, r);
		if (r.hasErrors()) {
			return "landing";
		}
		us.createUser(u);
		return "redirect:/";
	}
	
	// method accepts requests for / and /dashboard URLs
	@RequestMapping(value = {"/dashboard"})
	public String dash(Principal p, Model m) {
		String u = p.getName();
		us.recordLogin(us.findByUsername(u));
		m.addAttribute("user", us.findByUsername(u));
		return "dash";
	}
	
}
