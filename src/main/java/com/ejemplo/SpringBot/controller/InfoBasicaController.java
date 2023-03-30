
package com.ejemplo.SpringBot.controller;

import com.ejemplo.SpringBot.model.InfoBasica;
import com.ejemplo.SpringBot.service.IInfoBasicaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoBasicaController {
    
    
    // CONTROLLER OF InfoBasica
    @Autowired
    private IInfoBasicaService infoServ;      
    
    @PostMapping ("/new/info")
    public void agregarInfoBasica (@RequestBody InfoBasica cre){
        infoServ.crearInfoBasica(cre);
    }   
    @GetMapping ("/ver/info")
    @ResponseBody
    public List<InfoBasica> verInfo(){
        return infoServ.verInfo();
    } 
    
    @PutMapping ("/edit/info")
    public void editarInfoBasica (@RequestBody InfoBasica edi){
        infoServ.editarInfoBasica(edi);
    }
    
}
