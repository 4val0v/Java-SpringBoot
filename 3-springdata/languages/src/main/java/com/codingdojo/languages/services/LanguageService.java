package com.codingdojo.languages.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.languages.models.Language;

@Service
public class LanguageService {

    private List<Language> languages = new ArrayList(Arrays.asList(
    		new Language("Java", "James Gosling", "1.8"),
    		new Language("Python", "Guido van Rossum", "3.6"),
    		new Language("Javascript", "Brendan Eich", "1.9.5.23.247.2")
    		));
    
    public List<Language> allLanguages() {
        return languages;
    }

    public Language getLanguage(int idx) {
		if (idx < languages.size()) {
			return languages.get(idx);
		} else {
			return null;
		}
	}
    
    public void addLanguage(Language language) {
    		languages.add(language);
    }
    
    public void editLanguage(int idx, Language language) {
    		if (idx < languages.size()) {
    			languages.set(idx, language);
    		}
    }
    
    public void deleteLanguage(int idx) {
        if (idx < languages.size()){
            languages.remove(idx);
        }
    }
}