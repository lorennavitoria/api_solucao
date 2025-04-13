package com.hackamt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackamt.model.Formulario;
import com.hackamt.model.Pessoa;
import com.hackamt.model.RegistroVisita;
import com.hackamt.model.dto.FormularioDto;
import com.hackamt.repository.FormularioRepository;
import com.hackamt.repository.PessoaRepository;
import com.hackamt.repository.RegistroVisitaRepository;

import jakarta.transaction.Transactional;

@Service
public class FormularioService {
	
	
	@Autowired
	private FormularioRepository formularioRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private RegistroVisitaRepository registroVisitaRepository;

	@Transactional
	public String salvarFormulario(Long idenAgente, FormularioDto formularioDto) {
		
		
		try {
			Formulario formularioNovo = new Formulario();
			Optional<Pessoa> pessoaTry = pessoaRepository.findById(idenAgente);
			if(pessoaTry.isPresent()) {
				Pessoa pessoa = pessoaTry.get();
				formularioNovo.setPessoa(pessoa);
			}else {
				return "Agente não encontrado";
			}
			
			formularioNovo.setMunicipio(formularioDto.getMunicipio());
			formularioNovo.setCodigoNomeLocalidade(formularioDto.getCodigoNomeLocalidade());
			formularioNovo.setCategoria(formularioDto.getCategoria());
			formularioNovo.setZona(formularioDto.getZona());
			formularioNovo.setTipoAtividade(formularioDto.getTipoAtividade());
			formularioNovo.setCiclo(formularioDto.getCiclo());
			formularioNovo.setZonaConcluida(formularioDto.isZonaConcluida());
			formularioNovo.setTotalDepositos(formularioDto.getTotalDepositos());
			
			Optional<Pessoa> supervisorTry = pessoaRepository.findById(formularioDto.getIdenSupervisor());
			if(supervisorTry.isPresent()) {
				Pessoa supervisor = supervisorTry.get();
				formularioNovo.setSupervisor(supervisor);
			}else {
				return "Supervisor não encontrado";
			}
			
			formularioNovo.setNumeroSequenciaQuarteroes_aegypti(formularioDto.getNumeroSequenciaQuarteroes_aegypti());
			formularioNovo.setNumeroSequenciaQuarteroes_albopictus(formularioDto.getNumeroSequenciaQuarteroes_albopictus());
			
			Formulario formularioSalvo = formularioRepository.save(formularioNovo);
			
			
			for(RegistroVisita r: formularioDto.getRegistroVisitaList()) {
				r.setFormulario(formularioSalvo);
				registroVisitaRepository.save(r);
			}
			
			return "Formulário salvo com sucesso!";
		}catch (Exception e) {
			return "Não foi possível salvar o formulário";
		}
		
		
		
	}
	
	
	

}
