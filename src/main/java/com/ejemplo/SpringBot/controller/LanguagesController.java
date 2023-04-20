
package com.ejemplo.SpringBot.controller;

import com.ejemplo.SpringBot.excepciones.ResourceNotFoundException;
import com.ejemplo.SpringBot.model.Languages;
import com.ejemplo.SpringBot.repository.LanguagesRepository;
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
public class LanguagesController {
    
    @Autowired
    private LanguagesRepository reposki;      
    
    @GetMapping("/languages")
    public List<Languages> listarTodosLosLanguages()
    {
        return reposki.findAll();
    }
    //este metodo sirve para guardar el info
    @PostMapping("/languages")
    public Languages guardarLanguages(@RequestBody Languages skill) {
        return reposki.save(skill);
    }
    //este metodo sirve para buscar un info
    @GetMapping("/languages/{id}")
    public ResponseEntity<Languages> obtenerLanguagesPorId(@PathVariable Long id){
        Languages info= reposki.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el empleado con el ID : " + id));
        return ResponseEntity.ok(info);
    }
    //este metodo sirve para actualizar empleado
    @PutMapping("/languages/{id}")
    public ResponseEntity<Languages> actualizarLanguages(@PathVariable Long id,@RequestBody Languages detallesLanguages){
      Languages info = reposki.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el info con el ID : " + id));

        info.setTitulo(detallesLanguages.getTitulo());
        info.setPorcentaje(detallesLanguages.getPorcentaje());
        

        Languages skillsActualizado = reposki.save(info);
        return ResponseEntity.ok(skillsActualizado);
    }
    //este metodo sirve para eliminar un empleado
    @DeleteMapping("/languages/{id}")
    public ResponseEntity<Object> eliminarLanguages(@PathVariable Long id){
        Languages info = reposki.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el info con el ID : " + id));

        reposki.delete(info);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminar",Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
    
    
    
    /*
     // CONTROLLER OF Languages
    @Autowired
    private ILanguagesService lanServ;
    
    @GetMapping("/languages")
    public List <Languages> listarTodosLosLanguages (){
        return lanServ.listarTodosLosLanguages();
    }
    
      @PostMapping("/languages")
    public void guardarLanguages (@RequestBody Languages lan){
        lanServ.guardarLanguages(lan);
    }
    @GetMapping("/languages/{id}")
    public ResponseEntity<Languages> obtenerLanguagesPorId(@PathVariable Long id){
        return lanServ.obtenerLanguagesPorId(id);
    }
    @PutMapping("/languages/{id}")
    public ResponseEntity<Languages> actualizarLanguages(@PathVariable Long id,Languages detallesLanguages){
        return lanServ.actualizarLanguages(id,detallesLanguages);
    }
    @DeleteMapping("/languages/{id}")
    public ResponseEntity<Object> eliminarLanguages(@PathVariable Long id){
        return lanServ.eliminarLanguages(id);
    }
*/
}