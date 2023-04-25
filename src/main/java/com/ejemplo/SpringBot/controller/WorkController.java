
package com.ejemplo.SpringBot.controller;

import com.ejemplo.SpringBot.excepciones.ResourceNotFoundException;
import com.ejemplo.SpringBot.model.WorkExp;
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
@CrossOrigin(origins = "https://hosting-angularr.web.app")
public class WorkController {
    
    
    
    @Autowired
    private WorkRepository repositoriot;

    //este metodo sirve para listar todos los empleados
    @GetMapping("/work")
    public List<WorkExp> listarTodos() {
        return repositoriot.findAll();
    }


    //este metodo sirve para guardar el empleado
    @PostMapping("/work")
    public WorkExp guardar(@RequestBody WorkExp educationt) {
        return repositoriot.save(educationt);
    }

    //este metodo sirve para buscar un empleado
    @GetMapping("/work/{id}")
    public ResponseEntity<WorkExp> obtenerPorId(@PathVariable Long id) {
        WorkExp educationt = repositoriot.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el work con el ID : " + id));
        return ResponseEntity.ok(educationt);
    }

    //este metodo sirve para actualizar empleado
    @PutMapping("/work/{id}")
    public ResponseEntity<WorkExp> actualizar(@PathVariable Long id, @RequestBody WorkExp detallesWorkExp) {
        WorkExp educationt = repositoriot.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el work con el ID : " + id));

        educationt.setTitulot(detallesWorkExp.getTitulot());
        educationt.setIniciot(detallesWorkExp.getIniciot());
        educationt.setFint(detallesWorkExp.getFint());
        educationt.setDescriptiont(detallesWorkExp.getDescriptiont());

        WorkExp educationtActualizado = repositoriot.save(educationt);
        return ResponseEntity.ok(educationtActualizado);
    }


    //este metodo sirve para eliminar un empleado
    @DeleteMapping("/work/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable Long id) {
        WorkExp educationt = repositoriot.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el work con el ID : " + id));

        repositoriot.delete(educationt);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminar", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
    
    
    
    
    
    /*
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
    }*/
    
}
