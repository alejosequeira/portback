package com.ejemplo.SpringBot.repository;


import com.ejemplo.SpringBot.model.Educationt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationtRepository extends JpaRepository <Educationt,Long> {
}
