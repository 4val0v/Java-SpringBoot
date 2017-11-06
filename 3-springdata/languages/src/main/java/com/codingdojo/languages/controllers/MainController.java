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
	
	@RequestMapping("/{id}")
	public String getLanguage(Model model, @PathVariable("id") Long id) {
		model.addAttribute("language", languageService.getLanguage(id));
		return "language";
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
	
    @RequestMapping("/{id}/edit")
    public String getEditForm(@PathVariable("id") Long id, Model model) {
        Language language = languageService.getLanguage(id);
        if (language != null){
            model.addAttribute("language", language);
            return "edit";
        }else{
            return "redirect:/";
        }
    }
    
    @PostMapping("/{id}/edit")
    public String submitLanguageEdit(
    		@PathVariable("id") Long id,
    		@Valid @ModelAttribute("language") Language language,
    		BindingResult result) {
    	
        if (result.hasErrors()) {
            return "edit";
        } else {
            languageService.editLanguage(language);
            return "redirect:/";
        }
    }
    
    @RequestMapping("/{id}/delete")
    public String deleteLanguage(@PathVariable("id") Long id) {
        languageService.deleteLanguage(id);
        return "redirect:/";
    }
	
}