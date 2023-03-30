
package com.ejemplo.SpringBot.service;

import com.ejemplo.SpringBot.model.InfoBasica;
import java.util.List;


public interface IInfoBasicaService {
    public List<InfoBasica> verInfo ();
    public void crearInfoBasica (InfoBasica cre);
    public void editarInfoBasica (InfoBasica edi);
    
}
