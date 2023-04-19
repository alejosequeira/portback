
package com.ejemplo.SpringBot.service;

import com.ejemplo.SpringBot.model.AboutMe;
import java.util.List;




public interface IAboutMeService{
    
    public List <AboutMe> verAboutMe();
    public void crearAboutMe (AboutMe abo);
    public void editarAboutMe (AboutMe edi);
    public void borrarAboutMe (Long id);
}
