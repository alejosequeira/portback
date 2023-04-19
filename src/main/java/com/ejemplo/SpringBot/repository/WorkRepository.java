
package com.ejemplo.SpringBot.repository;


import com.ejemplo.SpringBot.model.WorkExp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface WorkRepository extends JpaRepository<WorkExp, Long>{
    
}
