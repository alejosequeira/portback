
package com.ejemplo.SpringBot.Controller;

import com.ejemplo.SpringBot.model.Login;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.ejemplo.SpringBot.service.ILoginService;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
public class LoginController {
    
    // CONTROLLER OF Persona
      @Autowired
   private ILoginService persoServ;    
      
      
    @PostMapping ("/new/persona")
    public void agregarPersona (@RequestBody Login pers){
       persoServ.crearPersona(pers);
    }  
    @PostMapping ("/buscar/correo/{id}")
    public String searchCorreo (@PathVariable Long id){
        return persoServ.obtenerCorreo(id);
    }
    @PostMapping ("/buscar/contra/{id}")
    public String searchContra (@PathVariable Long id){
        return persoServ.obtenerContra(id);
    }
    @PostMapping ("/buscar/corr")
    public boolean searchCorr (@PathVariable String s){
        return persoServ.obtenerCorr(s);
    }
    
    
    
    @GetMapping ("/ver/personas")
    @ResponseBody
    public List<Login> verPersonas(){         
       return persoServ.verPersonas();
    }    
    @DeleteMapping ("/delete/persona/{id}")
    public void borrarPersona(@PathVariable Long id){
    persoServ.borrarPersona(id);
    }    
    @PutMapping ("/edit/persona")
    public void editarPersona (@RequestBody Login per){
        persoServ.editarPersona(per);
    }   
    
    @PostMapping ("/buscar/persona/{id}")
    public Login searchPersona (@PathVariable Long id){
        return persoServ.buscarPersona(id);
    }
    
}
