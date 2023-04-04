
package com.ejemplo.SpringBot.service;

import com.ejemplo.SpringBot.model.UserPersona;
import com.ejemplo.SpringBot.repository.UserPersoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPersonaService implements IUserPersonaService{
      @Autowired
    private UserPersoRepository personaRepository;

    public UserPersonaService() {
    }

      @Override
    public void addPersona(UserPersona persona){
        personaRepository.save(persona);
    }

      @Override
    public void editPersona(UserPersona persona){
        personaRepository.save(persona);
    }

      @Override
    public List<UserPersona> getPersona(){
        return (List<UserPersona>) personaRepository.findAll();
    }
}
