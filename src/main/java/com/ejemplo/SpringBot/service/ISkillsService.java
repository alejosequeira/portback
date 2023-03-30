
package com.ejemplo.SpringBot.service;

import com.ejemplo.SpringBot.model.Skills;
import java.util.List;

public interface ISkillsService {
    
    public List <Skills> verSkills ();
    public void crearSkill (Skills ski);
    public void editarSkill (Skills edi);
}
