package com.codingdojo.displaydate.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
		
	LocalDateTime now = LocalDateTime.now();
	DateTimeFormatter date = DateTimeFormatter.ofPattern("EEEE', the' d 'of' MMMM',' u");
	DateTimeFormatter time = DateTimeFormatter.ofPattern("K:mm a");
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/date")
	public String date(Model model) {
		model.addAttribute("date", now.format(date));
		return "date";
	}
	
	@RequestMapping("/time")
	public String time(Model model) {
		model.addAttribute("time", now.format(time));
		return "time";
	}
	
}
