
package com.ejemplo.SpringBot.service;

import com.ejemplo.SpringBot.model.Languages;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface ILanguagesService {
    
    public List <Languages> listarTodosLosLanguages ();
    public Languages guardarLanguages(Languages skill);
    public ResponseEntity<Languages> obtenerLanguagesPorId(Long id);
    public ResponseEntity<Languages> actualizarLanguages(Long id,Languages detallesLanguages);
    public ResponseEntity<Object> eliminarLanguages(Long id);
}   
