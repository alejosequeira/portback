
package com.ejemplo.SpringBot.service;

import com.ejemplo.SpringBot.model.Proyects;
import com.ejemplo.SpringBot.repository.ProyectsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service

public class ProyectsService implements IProyectsService {
    @Autowired
    public ProyectsRepository proyRepo;

    @Override
    public List<Proyects> verProyects() {
        return proyRepo.findAll();
    }

    @Override
    public void crearProyects(Proyects pro) {
        proyRepo.save(pro);
    }

    @Override
    public void editarProyects(Proyects edi) {
        proyRepo.save(edi);
    }

    @Override
    public void borrarProyects(Long id) {
        proyRepo.deleteById(id);
    }
}
