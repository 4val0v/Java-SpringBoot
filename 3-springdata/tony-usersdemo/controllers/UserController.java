package com.project.ModelsApp.controllers;

import java.security.Principal;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.ModelsApp.services.UserService;
import com.project.ModelsApp.models.User;
import java.util.ArrayList;

@Controller
public class UserController{
	private UserService userService;

	public UserController(UserService userService){
		this.userService = userService;
	}

	@RequestMapping("")
	public String index(Model model,RedirectAttributes flash){
		System.out.println( flash.getFlashAttributes() );

		model.addAttribute("users",userService.all());
		model.addAttribute("user",new User());
		return "index";
	}

	@PostMapping("/users/new")
	public String create(@Valid @ModelAttribute("user") User user,BindingResult res,RedirectAttributes flash){
		if( res.hasErrors() ){
			flash.addFlashAttribute("errs",res.getAllErrors());
			return "redirect:/";
		}else{
			userService.create(user);
			return "redirect:/";
		}
	}
}
