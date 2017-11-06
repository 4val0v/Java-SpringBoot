package com.codingdojo.languages.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.codingdojo.languages.models.Language;
import com.codingdojo.languages.repositories.LanguageRepository;

@Service
public class LanguageService {

    private LanguageRepository languageRepository;
	
	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
    
    public List<Language> allLanguages() {
        return languageRepository.findAll();
    }

    public Language getLanguage(Long id) {
		return languageRepository.findOne(id);
	}
    
    // for multiple data source transactions
    // that must be performed together or not at all
    @Transactional
    public void addLanguage(Language language) {
    		languageRepository.save(language);
    }
    
    @Transactional
    public void editLanguage(Language language) {
    		languageRepository.save(language);
    }
    
    public void deleteLanguage(Long id) {
    		languageRepository.delete(id);
    }
}

