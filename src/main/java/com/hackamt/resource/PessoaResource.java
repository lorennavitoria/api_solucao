package com.hackamt.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hackamt.model.Pessoa;
import com.hackamt.model.dto.FormularioDto;
import com.hackamt.service.PessoaService;

import jakarta.annotation.Resource;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/pessoa")
public class PessoaResource {
	
	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping()
	public List<Pessoa> listarAgentes() {
	    return pessoaService.listarAgentes();
	}
	
	@GetMapping("/supervisores")
	public List<Pessoa> listarSupervisores(){
		return pessoaService.listarSupervisores();
	}
	
	@GetMapping("/buscarvalidador/{idenFormulario}")
	public Pessoa buscarValidadorFormulario(@PathVariable Long idenFormulario) {
		return pessoaService.buscarValidadorFormulario(idenFormulario);
	}
	
	@PostMapping("/login")
    public ResponseEntity<String> realizarLogin(@RequestParam String cpf, @RequestParam String senha) {
        String resultado = pessoaService.realizarLogin(cpf, senha);
        return ResponseEntity.ok(resultado);
    }

}
