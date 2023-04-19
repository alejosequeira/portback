
package com.ejemplo.SpringBot.repository;

import com.ejemplo.SpringBot.model.InfoBasica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoBasicaRepo extends JpaRepository <InfoBasica, Long> {
    
}
