package com.hackamt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackamt.model.Formulario;
import com.hackamt.model.Pessoa;
import com.hackamt.repository.FormularioRepository;
import com.hackamt.repository.PessoaRepository;

import jakarta.transaction.Transactional;

@Service
public class PessoaService {
	
	@Autowired
	PessoaRepository pessoaRepository;

	@Autowired
	FormularioRepository formularioRepository;

	public List<Pessoa> listarAgentes() {
		return pessoaRepository.findAll();
	}


	@Transactional
	public Pessoa buscarValidadorFormulario(Long idenFormulario) {
		
		Optional<Formulario> form = formularioRepository.findById(idenFormulario);
		
		if(form.isPresent()) {
		    Formulario formSalvo = form.get();
		    return formSalvo.getPessoa();
		}else {
			return null;
		}
	}

}
