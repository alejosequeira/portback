
package com.ejemplo.SpringBot.service;

import com.ejemplo.SpringBot.excepciones.ResourceNotFoundException;
import com.ejemplo.SpringBot.model.Languages;
import com.ejemplo.SpringBot.repository.LanguagesRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service 
public class LanguagesService implements ILanguagesService{
    
    @Autowired
    public LanguagesRepository reposki;

    @Override
    public List<Languages> listarTodosLosLanguages() {
        return reposki.findAll();
    }

    @Override
    public Languages guardarLanguages(Languages skill) {
        return reposki.save(skill);
    }

    @Override
    public ResponseEntity<Languages> obtenerLanguagesPorId(Long id) {
        Languages info= reposki.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el empleado con el ID : " + id));
        return ResponseEntity.ok(info);
    }

    @Override
    public ResponseEntity<Languages> actualizarLanguages(Long id, Languages detallesLanguages) {
        Languages info = reposki.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el info con el ID : " + id));

        info.setTitulo(detallesLanguages.getTitulo());
        info.setPorcentaje(detallesLanguages.getPorcentaje());
        

        Languages skillsActualizado = reposki.save(info);
        return ResponseEntity.ok(skillsActualizado);
    }

    @Override
    public ResponseEntity<Object> eliminarLanguages(Long id) {
        Languages info = reposki.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el info con el ID : " + id));

        reposki.delete(info);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminar",Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }

    
    
}
