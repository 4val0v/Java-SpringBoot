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
	public String lesson(Model model, @PathVariable("l") String l) {
		String content = "";
		if (l.equals("0733")) {
			content = "Setting up your servers";
		} else if (l.equals("0342")) {
			content = "Punch Cards";
		} else if (l.equals("0348")) {
			content = "Advanced Fortran Intro";
		}
		model.addAttribute("content", content);
		return "lesson";
	}
	
	@RequestMapping("/m/{c}/0483/{a}")
	public String assignment(Model model, @PathVariable("a") String a) {
		String content = "";
		if (a.equals("0345")) {
			content = "Coding Forms";
		} else if (a.equals("2342")) {
			content = "Fortran to Binary";
		}
		model.addAttribute("content", content);
		return "assignment";
	}
	
}
