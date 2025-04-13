package com.hackamt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackamt.model.Pessoa;
import com.hackamt.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	PessoaRepository pessoaRepository;


	public List<Pessoa> listarAgentes() {
		return pessoaRepository.findAll();
	}

}
