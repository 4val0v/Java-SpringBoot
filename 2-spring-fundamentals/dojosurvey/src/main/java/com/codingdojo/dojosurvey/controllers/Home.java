package com.codingdojo.dojosurvey.controllers;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class Home {
	
	private static final long serialVersionUID = 1L;
	
	@RequestMapping("")
	public String index() {
		return "index";
	}
	
	@PostMapping("send")
	public String send(HttpSession session,
		@RequestParam("name") String name,
		@RequestParam("dojo") String dojo,
		@RequestParam("stack") String stack,
		@RequestParam(value="comment", required=false) String comment) {

		session.setAttribute("name", name);
		session.setAttribute("dojo", dojo);
		session.setAttribute("stack", stack);
		session.setAttribute("comment", comment);
		
		return "redirect:result";
	}
	
	@RequestMapping("result")
	public String result(Model model, HttpSession session) {
		model.addAttribute("name", session.getAttribute("name"));
		model.addAttribute("dojo", session.getAttribute("dojo"));
		model.addAttribute("stack", session.getAttribute("stack"));
		model.addAttribute("comment", session.getAttribute("comment"));
		
		return "result";
	}

}
