
package com.ejemplo.SpringBot.controller;

import com.ejemplo.SpringBot.excepciones.ResourceNotFoundException;
import com.ejemplo.SpringBot.model.AboutMe;
import com.ejemplo.SpringBot.repository.AboutMeRepository;
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
public class AboutMeController {
    @Autowired
    private AboutMeRepository repoAbout;

    //este metodo sirve para listar todos los about
    @GetMapping("/about")
    public List<AboutMe> listarTodos()
    {
        return repoAbout.findAll();
    }

    //este metodo sirve para guardar el about
    @PostMapping("/about")
    public AboutMe guardar(@RequestBody AboutMe about) {
        return repoAbout.save(about);
    }

    //este metodo sirve para buscar un about
    @GetMapping("/about/{id}")
    public ResponseEntity<AboutMe> obtenerPorId(@PathVariable Long id){
        AboutMe aboutme= repoAbout.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el empleado con el ID : " + id));
        return ResponseEntity.ok(aboutme);
    }

    //este metodo sirve para actualizar empleado
    @PutMapping("/about/{id}")
    public ResponseEntity<AboutMe> actualizar(@PathVariable Long id,@RequestBody AboutMe detallesAboutMe){
        AboutMe aboutme = repoAbout.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el about con el ID : " + id));

        aboutme.setDescripcion(detallesAboutMe.getDescripcion());

        AboutMe aboutmeActualizado = repoAbout.save(aboutme);
        return ResponseEntity.ok(aboutmeActualizado);
    }

    //este metodo sirve para eliminar un empleado
    @DeleteMapping("/about/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable Long id){
        AboutMe aboutme = repoAbout.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el about con el ID : " + id));

        repoAbout.delete(aboutme);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminar",Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}
