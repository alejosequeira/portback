
package com.ejemplo.SpringBot.controller;

import com.ejemplo.SpringBot.model.Languages;
import com.ejemplo.SpringBot.service.ILanguagesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LanguagesController {
     // CONTROLLER OF Languages
    @Autowired
    private ILanguagesService lanServ;
    
    @PostMapping ("/new/language")
    public void agregarLanguage (@RequestBody Languages lan){
        lanServ.crearLanguage(lan);
    }
    @GetMapping ("/ver/languages")
    @ResponseBody
    public List <Languages> verLanguageses(){
        return lanServ.verLanguages();
    }
    @PutMapping ("/edit/language")
    public void editarLanguage (@RequestBody Languages edi){
        lanServ.editarLanguage(edi);
    }
}