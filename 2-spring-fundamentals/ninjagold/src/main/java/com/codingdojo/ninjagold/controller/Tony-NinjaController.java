package com.project.NinjaGold2.controllers;

import java.security.Principal;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.Random;
import java.util.ArrayList;

@Controller
public class NinjaController{
	//Member variables go here
	private Random random;
	private String res;

	public NinjaController(){
		this.random = new Random();
	}
	
	// public void setGold(int gold,HttpSession session){
	// 	session.setAttribute("gold",gold);
	// }
	// public Object getGold(HttpSession session){
	// 	return session.getAttribute("gold");
	// }

	// public void setKey(String key,String value,HttpSession session){
	// 	session.setAttribute(key,value);
	// }
	// public Object getKey(String key, HttpSession session){
	// 	return session.getAttribute(key);
	// }

	@RequestMapping("/gold")
	public String index(HttpSession session){		
		// if(getGold(session) == null)
		// 	setGold(0,session);

		if(session.getAttribute("gold") == null)
			session.setAttribute("gold",0);
		if(session.getAttribute("activities") == null)
			session.setAttribute("activities", new ArrayList<String>() );

		return "index";
	}
	
	@PostMapping("/process")
	public String process(@RequestBody() String body, HttpSession session){
		body = body.substring(0, body.indexOf("=") );
		int result = 0;
		res = "You entered a ";

		switch(body){
			case "farm":
				result = random.nextInt(10)+10;
				break;
			case "cave":
				result = random.nextInt(5)+5;
				break;
			case "house":
				result = random.nextInt(4) + 2;
				break;
			case "casino":
				result = random.nextInt(50);
				result = random.nextInt(2)+1 == 1 ? result : -result;
				
				break;

			}
		res += body+" and earned "+result+" gold.";
		session.setAttribute("gold",(int)session.getAttribute("gold")+result);

		ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities"); 
		activities.add(res);
		session.setAttribute("activities",activities);

		return "redirect:/gold";
	}
}
