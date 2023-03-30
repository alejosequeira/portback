
package com.ejemplo.SpringBot.controller;

import com.ejemplo.SpringBot.model.AboutMe;
import com.ejemplo.SpringBot.service.IAboutMeService;
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
public class AboutMeController {
    @Autowired
    private IAboutMeService aboServ;
    
    @PostMapping ("/new/about")
    public void agregarAboutMe(@RequestBody AboutMe abou){
        aboServ.crearAboutMe(abou);
    }
    
    @GetMapping ("/ver/about")
    @ResponseBody
    public List <AboutMe> verAbout(){
        return aboServ.verAboutMe();
    }
    
    @PutMapping ("/edit/about")
    public void editarAbout(@RequestBody AboutMe edi){
        aboServ.editarAboutMe(edi);
    }
    
    @DeleteMapping ("/delete/about/{id}")
    public void borrarAbout (@PathVariable Long id){
        aboServ.borrarAboutMe(id);
    }
}
