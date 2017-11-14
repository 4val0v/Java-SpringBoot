package com.project.rings.controllers;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.rings.models.User;
import com.project.rings.services.UserService;
import com.project.rings.validators.UserValidator;

@Controller
public class Users {
	
	private UserService us;
	private UserValidator uv;
	public Users (UserService us, UserValidator uv) {
		this.us = us;
		this.uv = uv;
	}
	
	@RequestMapping("/")
	public String landing(Model m, Principal p,
		@Valid @ModelAttribute("user") User u,
		@RequestParam(value="error", required=false) String e) {
		
		if (e != null) {
			m.addAttribute("error", "YOU SHALL NOT PASS");
		}
		return "landing";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User u,
		BindingResult r, Model m) {
		
		uv.validate(u, r);
		if (r.hasErrors()) {
			return "landing";
		}
		
		if (us.listAdmins().isEmpty()) {
			us.createAdmin(u);
		} else {
			us.createUser(u);
		}
		
		return "redirect:/";
	}
	
}
