package com.hackamt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackamt.model.Formulario;

@Repository
public interface FormularioRepository extends JpaRepository<Formulario, Long> {

}
