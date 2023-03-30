
package com.ejemplo.SpringBot.repository;

import com.ejemplo.SpringBot.model.Languages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguagesRepository extends JpaRepository<Languages, Long> {
    
}
