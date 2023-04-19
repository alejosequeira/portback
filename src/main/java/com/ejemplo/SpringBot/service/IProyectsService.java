
package com.ejemplo.SpringBot.service;

import com.ejemplo.SpringBot.model.Proyects;
import java.util.List;


public interface IProyectsService {
    
    public List <Proyects> verProyects();
    public void crearProyects(Proyects pro);
    public void editarProyects(Proyects edi);
    public void borrarProyects(Long id);
    
    
}
