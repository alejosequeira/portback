/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.SpringBot.controller;

import com.ejemplo.SpringBot.excepciones.ResourceNotFoundException;
import com.ejemplo.SpringBot.model.Photo;
import com.ejemplo.SpringBot.repository.PhotoRepository;
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
@CrossOrigin(origins = "https://hosting-angularr.web.app")
public class PhotoController {
    
    @Autowired
    private PhotoRepository repositoriot;

    //este metodo sirve para listar todos los empleados
    @GetMapping("/photo")
    public List<Photo> listarTodosLosPhoto() {
        return repositoriot.findAll();
    }


    //este metodo sirve para guardar el empleado
    @PostMapping("/photo")
    public Photo guardarPhoto(@RequestBody Photo educationt) {
        return repositoriot.save(educationt);
    }

    //este metodo sirve para buscar un empleado
    @GetMapping("/photo/{id}")
    public ResponseEntity<Photo> obtenerPhotoPorId(@PathVariable Long id) {
       Photo educationt = repositoriot.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe la foto con el ID : " + id));
        return ResponseEntity.ok(educationt);
    }

    //este metodo sirve para actualizar empleado
    @PutMapping("/photo/{id}")
    public ResponseEntity<Photo> actualizarPhoto(@PathVariable Long id, @RequestBody Photo detallesPhoto) {
       Photo educationt = repositoriot.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el proyect con el ID : " + id));

        educationt.setTitulot(detallesPhoto.getTitulot());

        Photo educationtActualizado = repositoriot.save(educationt);
        return ResponseEntity.ok(educationtActualizado);
    }


    //este metodo sirve para eliminar un empleado
    @DeleteMapping("/photo/{id}")
    public ResponseEntity<Object> eliminarPhoto(@PathVariable Long id) {
        Photo educationt = repositoriot.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el work con el ID : " + id));

        repositoriot.delete(educationt);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminar", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}
