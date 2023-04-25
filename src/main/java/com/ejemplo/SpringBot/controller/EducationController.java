
package com.ejemplo.SpringBot.controller;

import com.ejemplo.SpringBot.model.Education;
import com.ejemplo.SpringBot.service.IEducationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class EducationController {
    
    // CONTROLLER OF Education
    @Autowired
    private IEducationService educServ;
    
    @PostMapping ("/new/education")
    public void agregar (@RequestBody Education edu){
        educServ.crearEducation(edu);
    }
    @GetMapping ("/ver/education")
    @ResponseBody
    public List <Education> ver(){
        return educServ.verEducation();
    }
    @PutMapping ("/edit/education")
    public void editar (@RequestBody Education edi){
        educServ.editarEducation(edi);
    }
    @DeleteMapping ("/delete/education/{id}")
    public void borrar(@PathVariable Long id){
        educServ.borrarEducation(id);
    }
    
}
