package com.project.rings.controllers;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.rings.models.Guild;
import com.project.rings.models.Ring;
import com.project.rings.services.RingsService;
import com.project.rings.services.UserService;

@Controller
public class Rings {

	private UserService us;
	private RingsService rs;
	public Rings (UserService us, RingsService rs) {
		this.us = us;
		this.rs = rs;
	}
	
	@RequestMapping("/bind_in_darkness")
	public String dash(Principal p, Model m) {
		String u = p.getName();
		m.addAttribute("user", us.findByUsername(u));
		m.addAttribute("avail_rings", rs.listRings(us.isGreatAinur(true)));
		m.addAttribute("user_rings", rs.listRings(us.findByUsername(u)));
		return "dash";
	}
	
	@PostMapping("/bind_in_darkness")
	public String findRing(RedirectAttributes ra,
		@RequestParam("r_id") Long r_id,
		@RequestParam("u_id") Long u_id) {
		
		if (r_id == 0) {
			return "redirect:/bind_in_darkness";
		}
		
		// Add 5 min. rule! (check user.lastFind)
		
		rs.findRing(rs.getRingById(r_id), us.findById(u_id));
		
		return "redirect:/bind_in_darkness";
	}
	
	@RequestMapping("/ring_creator.exe")
	public String ringCreator(Model m,
		@ModelAttribute("ring") Ring ring) {
		return "ringCreator";
	}
	
	@PostMapping("/ring_creator.exe")
	public String forgeRing(@Valid @ModelAttribute("ring") Ring r,
		BindingResult res, Model m) {
		
		if (res.hasErrors()) {
			m.addAttribute("greatAinur", us.isGreatAinur(true));
			return "ringCreator";
		} else {
			rs.createRing(r);
			return "redirect:/ring_creator.exe";
		}
	}
	
	@RequestMapping("/fool_creator")
	public String foolCreator(Model m,
		@ModelAttribute("guild") Guild guild) {
		m.addAttribute("users", us.findAll());
		m.addAttribute("guilds", rs.listGuilds());
		
		// show age of users
		
		return "foolCreator";
	}
	
	@PostMapping("/fool_creator")
	public String createGuild(@Valid @ModelAttribute("guild") Guild g,
		BindingResult r, Model m) {
		
		if (r.hasErrors()) {
			return "foolCreator";
		} else {
			rs.createGuild(g);
			return "redirect:/fool_creator";
		}
	}
	
	@PostMapping("/fool_assigner")
	public String assignToGuild(RedirectAttributes ra,
		@RequestParam("g_id") Long g_id,
		@RequestParam("u_id") Long u_id) {
		
		if (g_id == 0 | u_id == 0) {
			return "redirect:/fool_creator";
		}
		// regulate against adding twice
		rs.assignGuild(us.findById(u_id), rs.getGuildById(g_id));
		
		return "redirect:/fool_creator";
	}
	
	@RequestMapping("/guild/{g}")
	public String guild(Model m,
		@PathVariable("g") Long g) {
		m.addAttribute("guild", rs.getGuildById(g));
		return "guild";
	}
	
	@RequestMapping("/fool_updater/{u}")
	public String foolUpdater(Model m,
		@PathVariable("u") Long u) {
		m.addAttribute("user", us.findById(u));
		return "foolUpdater";
	}
	
	@PostMapping("/fool_updater/{id}")
	public String updateFool(RedirectAttributes ra,
		@PathVariable("id") Long id,
		@RequestParam("username") String username) {
		
		us.updateUser(us.findById(id), username);
		
		return "redirect:/fool_updater/".concat(id.toString());
	}
	
	@RequestMapping("/fool_updater/{u}/destroy")
	public String delete(@PathVariable("u") Long u) {
		us.destroyUser(us.findById(u));
		return "redirect:/fool_creator";
	}
	
	@RequestMapping("/fool_updater/{u}/promote")
	public String promote(@PathVariable("u") Long u) {
		us.makeAdmin(us.findById(u));
		return "redirect:/fool_creator";
	}

}
