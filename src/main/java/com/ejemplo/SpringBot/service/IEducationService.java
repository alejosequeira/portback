
package com.ejemplo.SpringBot.service;

import com.ejemplo.SpringBot.model.Education;
import java.util.List;


public interface IEducationService {
    
    public List <Education> verEducation ();
    public void crearEducation (Education edu);
    public void editarEducation (Education edi);
    public void borrarEducation (Long id);
}
