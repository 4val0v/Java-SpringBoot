package com.project.dojoOverflow.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.dojoOverflow.models.Answer;
import com.project.dojoOverflow.models.Question;
import com.project.dojoOverflow.models.Tag;
import com.project.dojoOverflow.services.AService;
import com.project.dojoOverflow.services.QService;
import com.project.dojoOverflow.services.QTService;
import com.project.dojoOverflow.services.TService;

@Controller
@RequestMapping("/questions")
public class DojoController {

	private QService qs;
	private AService as;
	private TService ts;
	private QTService qts;
	
	public DojoController(
		QService qs, AService as,
		TService ts, QTService qts) {
		this.qs = qs;
		this.as = as;
		this.ts = ts;
		this.qts = qts;
	}
	
	@RequestMapping("")
	public String dashboard(Model m) {
		m.addAttribute("qs", qs.all());
		// for tags, iterate thru tags list object from questions
		return "dashboard";
	}
	
	@RequestMapping("/new")
	public String newQ(@ModelAttribute("q") Question q) {
		return "newQ";
	}
	
	@PostMapping("/new")
	public String addQ(RedirectAttributes r,
		@RequestParam("q") String q,
		@RequestParam("t1") String t1,
		@RequestParam("t2") String t2,
		@RequestParam("t3") String t3) {
		
		// set up flag variable validation
		boolean b = true;
		if (q.equals("")) {
			r.addFlashAttribute("qe", "Please enter a question.");
			b = false;
		}
		if (t1.equals("") && t2.equals("") && t3.equals("")) {
			r.addFlashAttribute("te", "Please add at least one tag.");
			b = false;
		}
		List<String> strings = new ArrayList<String>();
		strings.add(t1);
		strings.add(t2);
		strings.add(t3);
		for (String s : strings) {
			if (s.contains(" ")) {
				r.addFlashAttribute("te2", "Please remove spaces from your tags.");
				b = false;
			}
		}
		if (b == false) {
			return "redirect:/questions/new";
		}
		
		// instantiate and store tags
		List<Tag> tags = new ArrayList<Tag>();
		for (String s : strings) {
			Tag t = ts.findOrCreate(s);
			tags.add(t);
		}
		
		// instantiate and store question w/ tags list
		qs.create(new Question(q, tags));
		
		return "redirect:/questions";
	}
	
	@RequestMapping("/{qid}")
	public String showQ(Model m,
		@ModelAttribute("a") Answer a,
		@PathVariable("qid") Long qid) {
		
		m.addAttribute("q", qs.get(qid));
		m.addAttribute("ts", qts.byQuestion(qs.get(qid)));
		m.addAttribute("as", as.byQuestion(qs.get(qid)));
		
		return "showQ";
	}
	
	@PostMapping("/{qid}/add")
	public String addA(RedirectAttributes r,
		@PathVariable("qid") Long qid,
		@RequestParam("a") String a) {
		
		if (a.equals("")) {
			r.addFlashAttribute("qe", "Please enter an answer.");
		} else {
			as.create(new Answer(a, qs.get(qid)));
		}
		return "redirect:/questions/".concat(qid.toString());

	}
	
}
