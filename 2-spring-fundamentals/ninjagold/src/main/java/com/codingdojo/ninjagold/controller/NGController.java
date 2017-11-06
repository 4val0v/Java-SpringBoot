package com.codingdojo.ninjagold.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NGController {

	private static final long serialVersionUID = 1L;
	DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MMMM d', 'u K:mm a");
	
	@RequestMapping("/")
	public String index(HttpSession session, Model model) {
		if(session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
			session.setAttribute("activities", "");
		}
		return "index";
	}
	
	@PostMapping("getmoney/")
	public String getmoney(
		HttpSession session,
		@RequestParam("location") String location) {
		
		if (location.equals("farm")) {
			Random r = new Random();
			int amt = r.nextInt(20) + 10;
			session.setAttribute("gold",
				(int) session.getAttribute("gold") + amt);
			LocalDateTime now = LocalDateTime.now();
			String date = now.format(fmt);
			session.setAttribute("activities",
				((String) session.getAttribute("activities")).concat(
					"Earned " + amt + " gold from the farm! (" + date + ")\n"));
		}
		
		if (location.equals("cave")) {
			Random r = new Random();
			int amt = r.nextInt(10) + 5;
			session.setAttribute("gold",
				(int) session.getAttribute("gold") + amt);
			LocalDateTime now = LocalDateTime.now();
			String date = now.format(fmt);
			session.setAttribute("activities",
				((String) session.getAttribute("activities")).concat(
					"Earned " + amt + " gold from the cave! (" + date + ")\n"));
		}
		
		if (location.equals("house")) {
			Random r = new Random();
			int amt = r.nextInt(5) + 2;
			session.setAttribute("gold",
				(int) session.getAttribute("gold") + amt);
			LocalDateTime now = LocalDateTime.now();
			String date = now.format(fmt);
			session.setAttribute("activities",
				((String) session.getAttribute("activities")).concat(
					"Earned " + amt + " gold from the house! (" + date + ")\n"));
		}
		
		if (location.equals("casino")) {
			Random r = new Random();
			int amt = r.nextInt(50) + 0;
			int gamble = r.nextInt(2) + 1;
			LocalDateTime now = LocalDateTime.now();
			String date = now.format(fmt);
			if (gamble == 1) {
				session.setAttribute("gold",
					(int) session.getAttribute("gold") + amt);
				session.setAttribute("activities",
					((String) session.getAttribute("activities")).concat(
						"Entered a casino and won " + amt + " gold!!! (" + date + ")\n"));
			} else {
				session.setAttribute("gold",
					(int) session.getAttribute("gold") - amt);
				session.setAttribute("activities",
					((String) session.getAttribute("activities")).concat(
						"Entered a casino and lost " + amt + " gold :((( (" + date + ")\n"));
			}
		}
		
		return "redirect:/";
	}
	
}
