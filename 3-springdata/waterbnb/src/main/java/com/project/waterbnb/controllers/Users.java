package com.project.waterbnb.controllers;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.waterbnb.models.User;
import com.project.waterbnb.services.UserService;
import com.project.waterbnb.validators.UserValidator;

@Controller
public class Users {
	
	private UserService us;
	private UserValidator uv;
	public Users (UserService us, UserValidator uv) {
		this.us = us;
		this.uv = uv;
	}
	
	@RequestMapping("/login")
	public String landing(Model m,
		@Valid @ModelAttribute("user") User u, Principal p,
		@RequestParam(value="error", required=false) String e,
		@RequestParam(value="logout", required=false) String l) {
		
		if (e != null) { m.addAttribute("error", "Invalid credentials."); }
		if (l != null) { m.addAttribute("logout", "Thanks for visiting!"); }
		
		return "loginJoin";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User u,
		BindingResult r, Model m, RedirectAttributes f) {
		
		uv.validate(u, r);
		if (r.hasErrors()) { m.addAttribute("errors", "!"); return "loginJoin"; }
		else { us.create(u); } f.addFlashAttribute("thanks", "Thanks for signing up!");
		return "redirect:/login";
	}
	
}
