package com.ejemplo.SpringBot.controller;


import com.ejemplo.SpringBot.excepciones.ResourceNotFoundException;
import com.ejemplo.SpringBot.model.Educationt;
import com.ejemplo.SpringBot.repository.EducationtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map; 

@RestController
@RequestMapping("/api/v2/")
@CrossOrigin(origins = "http://localhost:4200")
public class EducationtController {


    @Autowired
    private EducationtRepository repositoriot;

    //este metodo sirve para listar todos los empleados
    @GetMapping("/educationts")
    public List<Educationt> listarTodosLosEducationt() {
        return repositoriot.findAll();
    }


    //este metodo sirve para guardar el empleado
    @PostMapping("/educationts")
    public Educationt guardarEducationt(@RequestBody Educationt educationt) {
        return repositoriot.save(educationt);
    }

    //este metodo sirve para buscar un empleado
    @GetMapping("/educationts/{id}")
    public ResponseEntity<Educationt> obtenerEducationtPorId(@PathVariable Long id) {
        Educationt educationt = repositoriot.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el empleado con el ID : " + id));
        return ResponseEntity.ok(educationt);
    }

    //este metodo sirve para actualizar empleado
    @PutMapping("/educationts/{id}")
    public ResponseEntity<Educationt> actualizarEducationt(@PathVariable Long id, @RequestBody Educationt detallesEducationt) {
        Educationt educationt = repositoriot.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el empleado con el ID : " + id));

        educationt.setTitulot(detallesEducationt.getTitulot());
        educationt.setIniciot(detallesEducationt.getIniciot());
        educationt.setFint(detallesEducationt.getFint());
        educationt.setDescriptiont(detallesEducationt.getDescriptiont());

        Educationt educationtActualizado = repositoriot.save(educationt);
        return ResponseEntity.ok(educationtActualizado);
    }


    //este metodo sirve para eliminar un empleado
    @DeleteMapping("/educationts/{id}")
    public ResponseEntity<Object> eliminarEducationt(@PathVariable Long id) {
        Educationt educationt = repositoriot.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el empleado con el ID : " + id));

        repositoriot.delete(educationt);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminar", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}