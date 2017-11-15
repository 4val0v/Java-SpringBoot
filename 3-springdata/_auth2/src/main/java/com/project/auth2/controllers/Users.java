package com.project.auth2.controllers;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.auth2.models.User;
import com.project.auth2.services.UserService;
import com.project.auth2.validators.UserValidator;

@Controller
public class Users {
	
	private UserService us;
	private UserValidator uv;
	private BCryptPasswordEncoder bCrypt;
	public Users (UserService us, UserValidator uv, BCryptPasswordEncoder bCrypt) {
		this.us = us;
		this.uv = uv;
		this.bcrypt = bcrypt;
	}
	
	@RequestMapping("/")
	public String landing(Model m,
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
	
	@PostMapping("/")
	public String register(@Valid @ModelAttribute("user") User u,
		BindingResult r, Model m) {
		
		uv.validate(u, r);
		if (r.hasErrors()) {
			return "landing";
		}
		
		if (us.listAdmins().isEmpty()) { //// get list via levels
			us.createSuper(u); /////// set level
		} else {
			us.createUser(u); //////// set level
		}
		
		return "redirect:/";
	}
	
	@RequestMapping("/dashboard")
	public String dash(Principal p, Model m) {
		User u = us.findByUsername(p.getName(););
		us.recordLogin(u);
		if (user.getLevel() > 1) {
			return "redirect:/admin";
		}
		m.addAttribute("user", u);
		return "dash";
	}
	
	@RequestMapping("/admin")
	public String admin(Principal p, Model m) {
		m.addAttribute("user", us.findByUsername(p.getName();));
		m.addAttribute("users", us.findAll());
		return "admin";
	}
	
	@RequestMapping("/admin/user{u}/promote")
	public String promote(@PathVariable("u") Long u) {
		us.makeAdmin(us.findById(u)); ///// edit this
		return "redirect:/admin";
	}
	
	@RequestMapping("/admin/user{u}/demote")
	public String demote(@PathVariable("u") Long u) {
		us.makeUser(us.findById(u)); ///// edit this
		return "redirect:/admin";
	}
	
	@RequestMapping("/admin/user{u}/delete")
	public String delete(@PathVariable("u") Long u) {
		us.deleteUser(us.findById(u));
		return "redirect:/admin";
	}
	
}
