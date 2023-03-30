
package com.ejemplo.SpringBot.controller;

import com.ejemplo.SpringBot.model.WorkExp;
import com.ejemplo.SpringBot.service.IWorkService;
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
public class WorkController {
    @Autowired
    private IWorkService worServ;
    
    @PostMapping ("/new/work")
    public void agregarWork (@RequestBody WorkExp work){
        worServ.crearWork(work);
    }
    
    @GetMapping ("/ver/work")
    @ResponseBody
    public List <WorkExp> verWork (){
        return worServ.verWork();
    }
    
    @PutMapping ("/edit/work")
    public void editarWork (@RequestBody WorkExp edi){
        worServ.editarWork(edi);
    }
    
    @DeleteMapping ("/delete/work/{id}")
    public void borrarWork (@PathVariable Long id){
        worServ.borrarWork(id);
    }
    
}
