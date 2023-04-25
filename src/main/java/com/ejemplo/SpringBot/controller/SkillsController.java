
package com.ejemplo.SpringBot.controller;

import com.ejemplo.SpringBot.excepciones.ResourceNotFoundException;
import com.ejemplo.SpringBot.model.Skills;
import com.ejemplo.SpringBot.repository.SkillsRepository;
import com.ejemplo.SpringBot.service.ISkillsService;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/api/v2/")
@CrossOrigin(origins = "https://serverfront-291c8.web.app")
public class SkillsController {
    
    
    
    
    
    @Autowired
    private SkillsRepository reposki;      
    
    @GetMapping("/skills")
    public List<Skills> listarTodos()
    {
        return reposki.findAll();
    }
    //este metodo sirve para guardar el info
    @PostMapping("/skills")
    public Skills guardarSkills(@RequestBody Skills skill) {
        return reposki.save(skill);
    }
    //este metodo sirve para buscar un info
    @GetMapping("/skills/{id}")
    public ResponseEntity<Skills> obtenerPorId(@PathVariable Long id){
        Skills info= reposki.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el empleado con el ID : " + id));
        return ResponseEntity.ok(info);
    }
    //este metodo sirve para actualizar empleado
    @PutMapping("/skills/{id}")
    public ResponseEntity<Skills> actualizar(@PathVariable Long id,@RequestBody Skills detallesSkills){
      Skills info = reposki.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el info con el ID : " + id));

        info.setTitulo(detallesSkills.getTitulo());
        info.setPorcentaje(detallesSkills.getPorcentaje());
        

        Skills skillsActualizado = reposki.save(info);
        return ResponseEntity.ok(skillsActualizado);
    }
    //este metodo sirve para eliminar un empleado
    @DeleteMapping("/skills/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable Long id){
        Skills info = reposki.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el info con el ID : " + id));

        reposki.delete(info);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminar",Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
    
    
    
    
    
    /*
    // CONTROLLER OF Skills
    @Autowired
    private ISkillsService skillServ;
    
    @PostMapping ("/new/skill")
    public void agregarSkill (@RequestBody Skills ski){
        skillServ.crearSkill(ski);
    }
    @GetMapping ("/ver/skills")
    @ResponseBody
    public List <Skills> verSkill(){
        return skillServ.verSkills();
    }
    @PutMapping ("/edit/skill")
    public void editarSkills (@RequestBody Skills edi){
        skillServ.editarSkill(edi);
    }*/
    
}
