
package com.ejemplo.SpringBot.service;

import com.ejemplo.SpringBot.model.InfoBasica;
import com.ejemplo.SpringBot.repository.InfoBasicaRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoBasicaService implements IInfoBasicaService{
    @Autowired
    public InfoBasicaRepo infoRepo;
    
    @Override
    public List<InfoBasica> verInfo() {
        return infoRepo.findAll();
    }

    @Override
    public void crearInfoBasica(InfoBasica cre) {
        infoRepo.save(cre);
    }
    
    @Override
    public void editarInfoBasica(InfoBasica edi) {
        infoRepo.save(edi);
    }
    
}
