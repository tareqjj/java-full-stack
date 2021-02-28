package com.springdataone.languages.services;

import com.springdataone.languages.models.Language;
import com.springdataone.languages.repositories.LanguageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageService {
    private final LanguageRepository languageRepository;

    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    public List<Language> allLanguages() {
        return languageRepository.findAll();
    }

    public Language createLanguage(Language l) {
        return languageRepository.save(l);
    }

    public Language findLanguage(Long id) {
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if (optionalLanguage.isPresent())
            return optionalLanguage.get();
        else
            return null;
    }

    public Language updateLanguage(Language language){
        language.setName(language.getName());
        language.setCreator(language.getCreator());
        language.setVersion(language.getVersion());
        return languageRepository.save(language);
    }

    public void deleteLanguage(Long id) {
        languageRepository.deleteById(id);
    }
}
