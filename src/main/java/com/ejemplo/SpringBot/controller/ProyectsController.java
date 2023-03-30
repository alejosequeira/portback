
package com.ejemplo.SpringBot.controller;

import com.ejemplo.SpringBot.model.Proyects;
import com.ejemplo.SpringBot.service.IProyectsService;
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
public class ProyectsController {
    @Autowired
    public IProyectsService proServ;
    
    @PostMapping ("/new/proyect")
    public void agregarProyect(@RequestBody Proyects pro){
        proServ.crearProyects(pro);
    }
    
    @GetMapping ("/ver/proyects")
    @ResponseBody
    public List<Proyects> verProyects(){
        return proServ.verProyects();
    }
    
    @PutMapping ("/edit/proyect")
    public void editarProyect(@RequestBody Proyects edi){
        proServ.editarProyects(edi);
    }
    
    @DeleteMapping ("/delete/proyect/{id}")
    public void borrarProyect (@PathVariable Long id){
        proServ.borrarProyects(id);
    }
    
    }
