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
		return pessoaRepository.listarAgentes();
	}
	
	public List<Pessoa> listarSupervisores() {
		return pessoaRepository.listarSupervisores();
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
	
	public String realizarLogin(String cpf, String senha) {
		senha = senha.trim(); 
		
	    Optional<Pessoa> pessoaTry = pessoaRepository.findByCpf(cpf);

	    if (pessoaTry.isPresent()) {
	        Pessoa pessoa = pessoaTry.get();

	        if (pessoa.getSenha().equals(senha)) {
	            if (!pessoa.isAtivo()) {
	                return "Usuário inativo";
	            }

	            String tipo;
	            if (pessoa.getTipoPessoa() == 1L) {
	                tipo = "1";
	            } else if (pessoa.getTipoPessoa() == 2L) {
	                tipo = "2";
	            } else {
	                tipo = "Tipo desconhecido";
	            }

	            return "Login realizado com sucesso! Tipo: " + tipo;
	        } else {
	            return "Senha incorreta";
	        }
	    } else {
	        return "CPF não encontrado";
	    }
	}



	

}
