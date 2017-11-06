package com.codingdojo.routingApp.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.routingApp.models.Student;

@Controller
public class StudentController {
	
	public static ArrayList<Student> students = new ArrayList<Student>();
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("students", students);
		return "index";
	}
	
	@PostMapping("/students/new")
	public String create(HttpSession session,
		@RequestParam("firstName") String firstName,
		@RequestParam("stack") String stack) {
		
		Student student = new Student(firstName, stack);
		students.add(student);
		session.setAttribute("latest", student);
		return "redirect:/";
	}
	
	@RequestMapping("/students/{id}") // Since 'students' is an ArrayList, each student is mapped to an index
	public String show(@PathVariable("id") int id, Model model) {
		model.addAttribute("student", students.get(id));
		return "show";
	}
	
	@RequestMapping("/session")
	public String session(HttpSession session, Model model) {
		Student latest = (Student) session.getAttribute("latest");
		model.addAttribute("latest", latest);
		return "session";
	}
	
}
