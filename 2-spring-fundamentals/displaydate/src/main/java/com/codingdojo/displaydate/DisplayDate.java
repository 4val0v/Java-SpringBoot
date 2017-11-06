package com.codingdojo.displaydate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DisplayDate {
	public static void main(String[] args) {
		SpringApplication.run(DisplayDate.class, args);
	}
	
}