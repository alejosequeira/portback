
package com.ejemplo.SpringBot.controller;

import com.ejemplo.SpringBot.model.UserPersona;
import com.ejemplo.SpringBot.service.IUserPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserPersonaController {
     @Autowired
    private IUserPersonaService personaService;

    @GetMapping("/miInfo")
    public List<UserPersona> getPersona(){
        return personaService.getPersona();
    }
    @PostMapping("/miInfo")
    public String addPersona(@RequestBody UserPersona persona){
        personaService.addPersona(persona);
        return "Todo salió bien";
    }

    @PutMapping("/miInfo")
        public String editPersona(@RequestBody UserPersona persona){
            personaService.editPersona(persona);
            return "Todo salió bien";
        }
       
}
