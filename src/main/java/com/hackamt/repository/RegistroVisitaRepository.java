package com.hackamt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hackamt.model.Formulario;
import com.hackamt.model.RegistroVisita;

@Repository
public interface RegistroVisitaRepository extends JpaRepository<RegistroVisita, Long> {

	@Query("Select r from RegistroVisita r "
			+ "where r.formulario.idenFormulario = :idenFormulario ")
	List<RegistroVisita> buscarByIdenFormulario(Long idenFormulario);

}
