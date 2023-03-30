
package com.ejemplo.SpringBot.service;

import com.ejemplo.SpringBot.model.Languages;
import com.ejemplo.SpringBot.repository.LanguagesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class LanguagesService implements ILanguagesService{
    
    @Autowired
    public LanguagesRepository langRepo;

    @Override
    public List<Languages> verLanguages() {
        return langRepo.findAll();
    }

    @Override
    public void crearLanguage(Languages lan) {
        langRepo.save(lan);
    }

    @Override
    public void editarLanguage(Languages edi) {
        langRepo.save(edi);
    }
      
    
}
