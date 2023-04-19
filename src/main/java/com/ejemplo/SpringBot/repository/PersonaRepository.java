
package com.ejemplo.SpringBot.repository;

import com.ejemplo.SpringBot.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository <Login, Long>{
Login findByEmail(String email);
}
