package com.ejemplo.SpringBot.repository;

import com.ejemplo.SpringBot.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository <Empleado,Long> {
}
