
package com.ejemplo.SpringBot.service;

import com.ejemplo.SpringBot.model.WorkExp;
import com.ejemplo.SpringBot.repository.WorkRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class WorkService implements IWorkService{
    @Autowired
    public WorkRepository workRepo;
    
    @Override
    public List<WorkExp> verWork() {
        return workRepo.findAll();
    }

    @Override
    public void crearWork(WorkExp wor) {
        workRepo.save(wor);
    }

    @Override
    public void borrarWork(Long id) {
        workRepo.deleteById(id);
    }

    @Override
    public void editarWork(WorkExp edi) {
        workRepo.save(edi);
    }
    
}
