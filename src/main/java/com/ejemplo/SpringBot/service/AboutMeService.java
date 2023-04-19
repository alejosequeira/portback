
package com.ejemplo.SpringBot.service;

import com.ejemplo.SpringBot.model.AboutMe;
import com.ejemplo.SpringBot.repository.AboutMeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AboutMeService implements IAboutMeService{
    @Autowired
    public AboutMeRepository aboutRepo;

    @Override
    public List<AboutMe> verAboutMe() {
        return aboutRepo.findAll();
    }

    @Override
    public void crearAboutMe(AboutMe abo) {
        aboutRepo.save(abo);
    }

    @Override
    public void editarAboutMe(AboutMe edi) {
        aboutRepo.save(edi);
    }

    @Override
    public void borrarAboutMe(Long id) {
        aboutRepo.deleteById(id);
    }
    
    
    
    
}
