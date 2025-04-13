package com.hackamt.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackamt.model.Pessoa;
import com.hackamt.model.dto.FormularioDto;
import com.hackamt.service.FormularioService;

import jakarta.annotation.Resource;

@RestController
@RequestMapping("/formulario")
public class FormularioResource {
	
	
	
	@Autowired
	private FormularioService formularioService;
	
	
	@PostMapping("/{idenAgente}")
	public ResponseEntity<String> salvarFormulario(@PathVariable Long idenAgente, @RequestBody FormularioDto formularioDto) {
	    return ResponseEntity.ok(formularioService.salvarFormulario(idenAgente, formularioDto)); 
	}
	
	@PutMapping("/{idenFormulario}")
	public ResponseEntity<String> editarFormulario(@PathVariable Long idenFormulario, @RequestBody FormularioDto formularioDto) {
	    return ResponseEntity.ok(formularioService.editarFormulario(idenFormulario, formularioDto)); 
	}
	
	@PutMapping("/validar/{idenFormulario}/{idenValidador}")
	public ResponseEntity<String> validarFormulario(@PathVariable Long idenFormulario, @PathVariable Long idenValidador){
		return ResponseEntity.ok(formularioService.validarFormulario(idenFormulario, idenValidador));
	}
	
	
	

}
