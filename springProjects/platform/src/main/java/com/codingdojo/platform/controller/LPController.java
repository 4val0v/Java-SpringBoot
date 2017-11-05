package com.codingdojo.platform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LPController {

	@RequestMapping("")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/m/{c}/0553/{l}")
	public String lesson(Model model,
		@PathVariable("c") String c,
		@PathVariable("l") String l) {
		
		if (c.equals("38")) {
			if (l.equals("0733")) {
				model.addAttribute("content", "Setting up your servers");
			}
			if (l.equals("0342")) {
				model.addAttribute("content", "Punch Cards");
			}
		} else if (c.equals("26")) {
			if (l.equals("0348")) {
				model.addAttribute("content", "Advanced Fortran Intro");
			}
		} else {
			model.addAttribute("content", "");
		}
		
		return "lesson";
	}
	
	@RequestMapping("/m/{c}/0483/{a}")
	public String assignment(Model model,
		@PathVariable("c") String c,
		@PathVariable("a") String a) {
		
		if (c.equals("38")) {
			if (a.equals("0345")) {
				model.addAttribute("content", "Coding Forms");
			}
		}
		if (c.equals("26")) {
			if (a.equals("2342")) {
				model.addAttribute("content", "Fortran to Binary");
			}
		} else {
			model.addAttribute("content", "");
		}
		
		return "assignment";
	}
	
}
