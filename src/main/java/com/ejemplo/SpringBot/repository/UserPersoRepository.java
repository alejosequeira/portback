
package com.ejemplo.SpringBot.repository;

import com.ejemplo.SpringBot.model.UserPersona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserPersoRepository extends CrudRepository<UserPersona, Integer> {
    
}
