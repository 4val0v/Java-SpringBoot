package com.codingdojo.thecode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TCController {

    @RequestMapping("/")
    public String index(@ModelAttribute("errors") String errors) {
        return "index";
    }

    @RequestMapping("/check")
    public String check(RedirectAttributes flash, @RequestParam("attempt") String attempt){
        
    		if (attempt.equals("bushido")) {
    			return "redirect:/code";
    		} else {
    			flash.addFlashAttribute("flash", "You must train harder!");
    			return "redirect:/";
    		}
    }
    
    @RequestMapping("/code")
    public String code() {
    		return "code";
    }
	
}
