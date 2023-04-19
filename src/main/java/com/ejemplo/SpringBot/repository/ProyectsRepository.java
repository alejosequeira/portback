
package com.ejemplo.SpringBot.repository;

import com.ejemplo.SpringBot.model.Proyects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProyectsRepository extends JpaRepository<Proyects, Long> {
    
}
