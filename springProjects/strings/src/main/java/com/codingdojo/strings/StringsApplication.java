package com.codingdojo.strings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// Import dependencies
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication

// Annotation
@RestController
public class StringsApplication {

	public static void main(String[] args) {
		SpringApplication.run(StringsApplication.class, args);
	}
	
	// Annotation & Method
	@RequestMapping("/")
	public String hello() {
		return "Hello client! How are you doing?";
	}
	
	// Annotation & Method
	@RequestMapping("/random")
	public String springboot() {
		return "Spring Boot is great! So easy to respond with strings";
	}
	
}
