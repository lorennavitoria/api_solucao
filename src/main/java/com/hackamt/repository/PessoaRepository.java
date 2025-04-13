package com.hackamt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hackamt.model.Formulario;
import com.hackamt.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>  {
	
	
	@Query("SELECT p FROM Pessoa p "
			+ "WHERE p.tipoPessoa = 1 ")
	List<Pessoa> listarSupervisores();
	
	@Query("SELECT p FROM Pessoa p "
			+ "WHERE p.tipoPessoa = 2 ")
	List<Pessoa> listarAgentes();

	@Query("SELECT p FROM Pessoa p "
			+ "WHERE p.cpf = :cpf ")
	Optional<Pessoa> findByCpf(String cpf);

}
