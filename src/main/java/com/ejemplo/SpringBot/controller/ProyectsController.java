
package com.ejemplo.SpringBot.controller;

import com.ejemplo.SpringBot.excepciones.ResourceNotFoundException;
import com.ejemplo.SpringBot.model.Proyects;
import com.ejemplo.SpringBot.model.WorkExp;
import com.ejemplo.SpringBot.repository.ProyectsRepository;
import com.ejemplo.SpringBot.repository.WorkRepository;
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
public class ProyectsController {
    
    @Autowired
    private ProyectsRepository repositoriot;

    //este metodo sirve para listar todos los empleados
    @GetMapping("/proyects")
    public List<Proyects> listarTodosLosProyects() {
        return repositoriot.findAll();
    }


    //este metodo sirve para guardar el empleado
    @PostMapping("/proyects")
    public Proyects guardarProyects(@RequestBody Proyects educationt) {
        return repositoriot.save(educationt);
    }

    //este metodo sirve para buscar un empleado
    @GetMapping("/proyects/{id}")
    public ResponseEntity<Proyects> obtenerProyectsPorId(@PathVariable Long id) {
       Proyects educationt = repositoriot.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el work con el ID : " + id));
        return ResponseEntity.ok(educationt);
    }

    //este metodo sirve para actualizar empleado
    @PutMapping("/proyects/{id}")
    public ResponseEntity<Proyects> actualizarProyects(@PathVariable Long id, @RequestBody Proyects detallesProyects) {
       Proyects educationt = repositoriot.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el proyect con el ID : " + id));

        educationt.setTitulot(detallesProyects.getTitulot());
        educationt.setIniciot(detallesProyects.getIniciot());
        educationt.setFint(detallesProyects.getFint());
        educationt.setDescriptiont(detallesProyects.getDescriptiont());

        Proyects educationtActualizado = repositoriot.save(educationt);
        return ResponseEntity.ok(educationtActualizado);
    }


    //este metodo sirve para eliminar un empleado
    @DeleteMapping("/proyects/{id}")
    public ResponseEntity<Object> eliminarProyects(@PathVariable Long id) {
        Proyects educationt = repositoriot.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el work con el ID : " + id));

        repositoriot.delete(educationt);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminar", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
    
    
    
    
    
    
    
    
    /*
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
    }*/
    
    }
