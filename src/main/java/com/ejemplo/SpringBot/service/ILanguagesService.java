
package com.ejemplo.SpringBot.service;

import com.ejemplo.SpringBot.model.Languages;
import java.util.List;

public interface ILanguagesService {
    
    public List <Languages> verLanguages ();
    public void crearLanguage (Languages lan);
    public void editarLanguage (Languages edi);
}
