
package com.ejemplo.SpringBot.service;

import com.ejemplo.SpringBot.model.Skills;
import com.ejemplo.SpringBot.repository.SkillsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class SkillsService implements ISkillsService{

    @Autowired
    public SkillsRepository skillsRepo;
    
    @Override
    public List<Skills> verSkills() {
        return skillsRepo.findAll();
    }

    @Override
    public void crearSkill(Skills ski) {
        skillsRepo.save(ski);
    }

    @Override
    public void editarSkill(Skills edi) {
        skillsRepo.save(edi);
    }
    
}
