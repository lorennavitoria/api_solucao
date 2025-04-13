package com.hackamt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackamt.model.Formulario;
import com.hackamt.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>  {

}
