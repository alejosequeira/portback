
package com.ejemplo.SpringBot.controller;

import com.ejemplo.SpringBot.model.Skills;
import com.ejemplo.SpringBot.service.ISkillsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SkillsController {
    
    // CONTROLLER OF Skills
    @Autowired
    private ISkillsService skillServ;
    
    @PostMapping ("/new/skill")
    public void agregarSkill (@RequestBody Skills ski){
        skillServ.crearSkill(ski);
    }
    @GetMapping ("/ver/skills")
    @ResponseBody
    public List <Skills> verSkill(){
        return skillServ.verSkills();
    }
    @PutMapping ("/edit/skill")
    public void editarSkills (@RequestBody Skills edi){
        skillServ.editarSkill(edi);
    }
    
}
