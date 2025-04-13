package com.hackamt.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackamt.model.Pessoa;
import com.hackamt.model.dto.FormularioDto;
import com.hackamt.service.PessoaService;

import jakarta.annotation.Resource;

@RestController
@RequestMapping("/pessoa")
public class PessoaResource {
	
	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping()
	public List<Pessoa> listarAgentes() {
	    return pessoaService.listarAgentes();
	}

}
