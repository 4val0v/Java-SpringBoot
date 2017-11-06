package com.codingdojo.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.languages.models.Language;
import com.codingdojo.languages.services.LanguageService;

@Controller
public class MainController {

	private LanguageService languageService;
	
	public MainController(LanguageService languageService){
	    this.languageService = languageService;
	}
	
	@RequestMapping("/")
    public String getAllLanguages(Model model,
    		@ModelAttribute("language") Language language) {
		List<Language> languages = languageService.allLanguages();
		model.addAttribute("languages", languages);
        return "index";
    }
	
	@RequestMapping("/{idx}")
	public String getLanguage(Model model, @PathVariable("idx") int idx) {
		Language language = languageService.getLanguage(idx);
		if (language != null) {
			model.addAttribute("language", language);
			model.addAttribute("idx", idx);
			return "language";
		} else {
			return "redirect:/";
		}
	}
	
	@PostMapping("/add")
	public String submitLanguage(Model model,
		@Valid @ModelAttribute("language") Language language,
		BindingResult result) {
		
		List<Language> languages = languageService.allLanguages();
		
		if (result.hasErrors()) {
			model.addAttribute("languages", languages);
			return "index";
		} else {
			languageService.addLanguage(language);
			return "redirect:/";
		}
	}
	
    @RequestMapping("/{idx}/edit")
    public String getEditForm(@PathVariable("idx") int idx, Model model) {
        Language language = languageService.getLanguage(idx);
        if (language != null){
            model.addAttribute("language", language);
            return "edit";
        }else{
            return "redirect:/";
        }
    }
    
    @PostMapping("/{idx}/edit")
    public String submitLanguageEdit(
    		@PathVariable("idx") int idx,
    		@Valid @ModelAttribute("language") Language language,
    		BindingResult result) {
    	
        if (result.hasErrors()) {
            return "edit";
        } else {
            languageService.editLanguage(idx, language);
            return "redirect:/";
        }
    }
    
    @RequestMapping("/{id}/delete")
    public String deleteLanguage(@PathVariable("id") int idx) {
        languageService.deleteLanguage(idx);
        return "redirect:/";
    }
	
}