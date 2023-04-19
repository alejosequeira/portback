
package com.ejemplo.SpringBot.service;

import com.ejemplo.SpringBot.model.UserPersona;
import java.util.List;


public interface IUserPersonaService {
    public void addPersona(UserPersona persona);
    public void editPersona(UserPersona persona);
    public List <UserPersona> getPersona();
    
        
}
