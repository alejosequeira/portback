package com.ejemplo.SpringBot.service;

import com.ejemplo.SpringBot.model.Login;
import java.util.List;

public interface ILoginService {
    
    public void crearPersona (Login per);    
    public String obtenerCorreo (Long id);    
    public String obtenerContra (Long id);
    public boolean obtenerCorr (String s);
    
    
    
    
    public void borrarPersona (Long id);
    public Login buscarPersona (Long id);
    public void editarPersona (Login id);    
    public List <Login> verPersonas ();   
}