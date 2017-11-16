package com.project.waterbnb.controllers;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.waterbnb.models.Pool;
import com.project.waterbnb.models.Review;
import com.project.waterbnb.models.User;
import com.project.waterbnb.services.PoolService;
import com.project.waterbnb.services.ReviewService;
import com.project.waterbnb.services.UserService;

@Controller
public class Pools{
	
	private UserService us;
	private PoolService ps;
	private ReviewService rs;
	public Pools(UserService us, PoolService ps, ReviewService rs){
		this.us = us;
		this.ps = ps;
		this.rs = rs;
	}
	
	// Search page
	@RequestMapping("/")
	public String search(Principal p, Model m){
		User user = us.getByUsername(p.getName());
		if (user.getLevel() == 2) { return "redirect:/host/dashboard"; }
		m.addAttribute("user", user);
		return "search";
	}
	
	// Search HTML Post
	@PostMapping("/search/q") // must be different from results route
	public String searchPost(@RequestParam("location") String location) {
		return "redirect:/search/?location=".concat(location);
	}

	// Search Results
	@RequestMapping("/search/")
	public String searchResults(Model m,
		@RequestParam(value="location", required=false) String search) {
		if (search.equals(null)) {search="?";}
		m.addAttribute("search", search);
		m.addAttribute("pools", ps.search(search));
		return "results";
	}
	
	// Host Dashboard
	@RequestMapping("/host/dashboard")
	public String hostDash(Model m, Principal p,
		@ModelAttribute("pool") Pool pool) {
		User user = us.getByUsername(p.getName());
		m.addAttribute("user", user);
		return "hostDash";
	}
	
	// POST to Add Pool
	@PostMapping("/host/dashboard/new") // same as form
	public String addPool(@Valid @ModelAttribute("pool") Pool pool,
		BindingResult r, Model m, Principal p) {
		if (r.hasErrors()) {
			m.addAttribute("errors", "!");
			User user = us.getByUsername(p.getName());
			m.addAttribute("user", user);
			return "hostDash";
		} else {
			ps.create(pool);
			return "redirect:/host/dashboard";
		}
	}
	
	// Show/Update Pool for Hosts
	@RequestMapping("/host/pools/{id}")
	public String adminPool(Model m, Principal u,
		@PathVariable("id") Long id,
		@ModelAttribute("pool") Pool pool) {
		
		m.addAttribute("p", ps.get(id));
		m.addAttribute("reviews", rs.getReviews(ps.get(id)));
		User user = us.getByUsername(u.getName());
		m.addAttribute("user", user);
		return "showPool";
	}
	
	// Show Pool for Anon/Guests
	@RequestMapping("/pools/{id}")
	public String showPool(Model m, Principal u,
		@PathVariable("id") Long id) {
		
		m.addAttribute("p", ps.get(id));
		m.addAttribute("reviews", rs.getReviews(ps.get(id)));
		User user = us.getByUsername(u.getName());
		m.addAttribute("user", user);
		return "showPool";
	}
	
	// Add Review
	@RequestMapping("/pools/{id}/review")
	public String review(Model m, Principal p,
		@ModelAttribute("review") Review review,
		@PathVariable("id") Long id) {
		m.addAttribute("p", ps.get(id));
		User user = us.getByUsername(p.getName());
		m.addAttribute("user", user);
		return "addReview";
	}
	
	// POST to Add Review
	@PostMapping("/pools/{id}/review") // same as form
	public String addReview(@PathVariable("id") String id,
		@Valid @ModelAttribute("review") Review review,
		BindingResult r, Model m, Principal p) {
		if (r.hasErrors()) {
			m.addAttribute("errors", "!");
			User user = us.getByUsername(p.getName());
			m.addAttribute("user", user);
			return "hostDash";
		} else {
			rs.create(review);
			return "redirect:/pools/".concat(id);
		}
	}
	



}
