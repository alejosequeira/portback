
package com.ejemplo.SpringBot.controller;

import com.ejemplo.SpringBot.excepciones.ResourceNotFoundException;
import com.ejemplo.SpringBot.model.InfoBasica;
import com.ejemplo.SpringBot.repository.InfoBasicaRepo;
import com.ejemplo.SpringBot.service.IInfoBasicaService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/")
@CrossOrigin(origins = "https://serverfront-291c8.web.app")
public class InfoBasicaController {
    
    
    // CONTROLLER OF InfoBasica
    @Autowired
    private InfoBasicaRepo repoInfo;      
    
    @GetMapping("/info")
    public List<InfoBasica> listarTodosLosInfoBasica()
    {
        return repoInfo.findAll();
    }
    //este metodo sirve para guardar el info
    @PostMapping("/info")
    public InfoBasica guardarInfoBasica(@RequestBody InfoBasica info) {
        return repoInfo.save(info);
    }
    //este metodo sirve para buscar un info
    @GetMapping("/info/{id}")
    public ResponseEntity<InfoBasica> obtenerInfoBasicaPorId(@PathVariable Long id){
        InfoBasica info= repoInfo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el empleado con el ID : " + id));
        return ResponseEntity.ok(info);
    }
    //este metodo sirve para actualizar empleado
    @PutMapping("/info/{id}")
    public ResponseEntity<InfoBasica> actualizarInfoBasica(@PathVariable Long id,@RequestBody InfoBasica detallesInfoBasica){
      InfoBasica info = repoInfo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el info con el ID : " + id));

        info.setDescription(detallesInfoBasica.getDescription());
        info.setLocation(detallesInfoBasica.getLocation());
        info.setEmail(detallesInfoBasica.getEmail());
        info.setNumero(detallesInfoBasica.getNumero());

        InfoBasica infobasicaActualizado = repoInfo.save(info);
        return ResponseEntity.ok(infobasicaActualizado);
    }
    //este metodo sirve para eliminar un empleado
    @DeleteMapping("/info/{id}")
    public ResponseEntity<Object> eliminarInfoBasica(@PathVariable Long id){
        InfoBasica info = repoInfo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el info con el ID : " + id));

        repoInfo.delete(info);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminar",Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
    
    
    
    /*
    
    
    @PostMapping ("/info")
    public void agregarInfoBasica (@RequestBody InfoBasica cre){
        infoServ.crearInfoBasica(cre);
    }   
    @GetMapping ("/info")
    @ResponseBody
    public List<InfoBasica> verInfo(){
        return infoServ.verInfo();
    } 
    
    @PutMapping ("/edit/info")
    public void editarInfoBasica (@RequestBody InfoBasica edi){
        infoServ.editarInfoBasica(edi);
    }*/
    
}
