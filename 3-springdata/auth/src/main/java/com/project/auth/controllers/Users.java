package com.project.auth.controllers;

import java.security.Principal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.auth.models.User;
import com.project.auth.services.UserDetailsAuthService;
import com.project.auth.services.UserService;
import com.project.auth.validators.UserValidator;

@Controller
public class Users {
	
	private UserService us;
	private UserDetailsAuthService udas;
	private UserValidator uv;
	public Users (UserService us, UserDetailsAuthService udas, UserValidator uv) {
		this.us = us;
		this.udas = udas;
		this.uv = uv;
	}
	
	@RequestMapping("/")
	public String landing(Model m, Principal p,
		@Valid @ModelAttribute("user") User u,
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
		
		if (us.listAdmins().size() == 0) {
			us.createSuper(u);
		} else {
			us.createUser(u);
		}
		return "redirect:/";
	}
	
	@RequestMapping("/dashboard")
	public String dash(Principal p, Model m) {
		String u = p.getName();
		us.recordLogin(us.findByUsername(u));
		m.addAttribute("user", us.findByUsername(u));
		return "dash";
	}
	
	@RequestMapping("/admin")
	public String admin(Principal p, Model m) {
		String u = p.getName();
		us.recordLogin(us.findByUsername(u));
		m.addAttribute("user", us.findByUsername(u));
		m.addAttribute("users", us.findAll());
		return "admin";
	}
	
	@RequestMapping("/admin/user{u}/promote")
	public String promote(@PathVariable("u") Long u) {
		us.makeAdmin(us.findById(u));
		return "redirect:/admin";
	}
	
	@RequestMapping("/admin/user{u}/demote")
	public String demote(@PathVariable("u") Long u) {
		us.makeUser(us.findById(u));
		return "redirect:/admin";
	}
	
	@RequestMapping("/admin/user{u}/delete")
	public String delete(@PathVariable("u") Long u) {
		us.deleteUser(us.findById(u));
		return "redirect:/admin";
	}
	
}
