
package com.ejemplo.SpringBot.service;

import com.ejemplo.SpringBot.model.WorkExp;
import java.util.List;



public interface IWorkService {
    public List <WorkExp> verWork();
    public void crearWork (WorkExp wor);
    public void borrarWork (Long id);
    public void editarWork (WorkExp edi);
}
