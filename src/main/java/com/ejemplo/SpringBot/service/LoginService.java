package com.ejemplo.SpringBot.service;

import com.ejemplo.SpringBot.model.Login;
import com.ejemplo.SpringBot.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class LoginService implements ILoginService{

    @Autowired
            
    public PersonaRepository persoRepo;
    
    @Override
    public void crearPersona(Login per) {
        persoRepo.save(per);
    }
     @Override
    public String obtenerCorreo(Long id) {
        return persoRepo.findById(id).orElse(null).getEmail();
    }
    @Override
    public String obtenerContra(Long id) {
        return persoRepo.findById(id).orElse(null).getPassword();
    }
    
    @Override
    public boolean obtenerCorr(String s) {
        boolean t=false;
        for(int i=0;i<persoRepo.findAll().size(); i++){
            if(persoRepo.equals(s)){
                t=true;
            }
        }
        return t;        
    }
    
    
    @Override
    public List<Login> verPersonas() {
        return persoRepo.findAll();
    }
    @Override
    public void borrarPersona(Long id) {
        persoRepo.deleteById(id);
    }

    
    
    @Override
    public void editarPersona(Login per){
        persoRepo.save(per);
    }

    @Override
    public Login buscarPersona(Long id) {
        return persoRepo.findById(id).orElse(null);
    }

    

   
    
}
