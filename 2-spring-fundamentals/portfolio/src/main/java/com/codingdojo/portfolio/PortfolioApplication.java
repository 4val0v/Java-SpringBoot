package com.codingdojo.portfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class PortfolioApplication {
	public static void main(String[] args) {
		SpringApplication.run(PortfolioApplication.class, args);
	}
	
	@Controller // indicates an annotated class is a web controller
	public class Ctrller {
		
		@RequestMapping("/")
		public String index() {
			return "index.html";
		}
		
		@RequestMapping("/me")
		public String me() {
			return "meh.html";
		}
		
		@RequestMapping("/projects")
		public String projects() {
			return "projectz.html";
		}
		
	}
	
//	@RestController
	// a combination of the @Controller and @ResponseBody annotations
	// @Controller indicates an annotated class is a web controller
	// @ResponseBody indicates method return value should be bound to the response body
	
//	public class RController {
//		
//		@RequestMapping("/world")
//		public String world() {
//			return "Class level annotations";
//		}
//		
//	}
	
}