package com.ejemplo.SpringBot.controller;

import com.ejemplo.SpringBot.excepciones.ResourceNotFoundException;
import com.ejemplo.SpringBot.model.Empleado;
import com.ejemplo.SpringBot.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "https://hosting-angularr.web.app")
public class EmpleadoController {

    @Autowired
    private EmpleadoRepository repositorio;

    //este metodo sirve para listar todos los empleado
    @GetMapping("/empleados")
    public List<Empleado> listarTodos() {
        return repositorio.findAll();
    }


    //este metodo sirve para guardar el empleado
    @PostMapping("/empleados")
    public Empleado guardar(@RequestBody Empleado empleado) {
        return repositorio.save(empleado);
    }

    //este metodo sirve para buscar un empleado
    @GetMapping("/empleados/{id}")
    public ResponseEntity<Empleado> obtenerPorId(@PathVariable Long id){
        Empleado empleado = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el empleado con el ID : " + id));
        return ResponseEntity.ok(empleado);
    }

    //este metodo sirve para actualizar empleado
    @PutMapping("/empleados/{id}")
    public ResponseEntity<Empleado> actualizar(@PathVariable Long id,@RequestBody Empleado detallesEmpleado){
        Empleado empleado = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el empleado con el ID : " + id));

        empleado.setNombre(detallesEmpleado.getNombre());
        empleado.setApellido(detallesEmpleado.getApellido());
        empleado.setEmail(detallesEmpleado.getEmail());

        Empleado empleadoActualizado = repositorio.save(empleado);
        return ResponseEntity.ok(empleadoActualizado);
    }

    //este metodo sirve para eliminar un empleado
    @DeleteMapping("/empleados/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminar(@PathVariable Long id){
        Empleado empleado = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el empleado con el ID : " + id));

        repositorio.delete(empleado);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminar",Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}
