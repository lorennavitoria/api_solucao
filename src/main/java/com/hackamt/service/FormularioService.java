package com.hackamt.service;

import java.util.List;
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
			formularioNovo.setFormularioValidado(false);
			
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

	@Transactional
	public String editarFormulario(Long idenFormulario, FormularioDto formularioDto) {
	    try {
	        Optional<Formulario> formularioOpt = formularioRepository.findById(idenFormulario);
	        if (!formularioOpt.isPresent()) {
	            return "Formulário não encontrado";
	        }

	        Formulario formulario = formularioOpt.get();

	        Optional<Pessoa> pessoaOpt = pessoaRepository.findById(formularioDto.getIdenPessoa());
	        if (!pessoaOpt.isPresent()) {
	            return "Agente não encontrado";
	        }

	        Optional<Pessoa> supervisorOpt = pessoaRepository.findById(formularioDto.getIdenSupervisor());
	        if (!supervisorOpt.isPresent()) {
	            return "Supervisor não encontrado";
	        }

	        formulario.setPessoa(pessoaOpt.get());
	        formulario.setMunicipio(formularioDto.getMunicipio());
	        formulario.setCodigoNomeLocalidade(formularioDto.getCodigoNomeLocalidade());
	        formulario.setCategoria(formularioDto.getCategoria());
	        formulario.setZona(formularioDto.getZona());
	        formulario.setTipoAtividade(formularioDto.getTipoAtividade());
	        formulario.setCiclo(formularioDto.getCiclo());
	        formulario.setZonaConcluida(formularioDto.isZonaConcluida());
	        formulario.setTotalDepositos(formularioDto.getTotalDepositos());
	        formulario.setSupervisor(supervisorOpt.get());
	        formulario.setNumeroSequenciaQuarteroes_aegypti(formularioDto.getNumeroSequenciaQuarteroes_aegypti());
	        formulario.setNumeroSequenciaQuarteroes_albopictus(formularioDto.getNumeroSequenciaQuarteroes_albopictus());

	        // Exclui os registros antigos antes de adicionar os novos
	        
	        List<RegistroVisita> registroVisitasList = registroVisitaRepository.buscarByIdenFormulario(idenFormulario);
	        
	        for(RegistroVisita r: registroVisitasList) {
	        	 registroVisitaRepository.deleteById(r.getIdenRegistroVisita());
	        }
	        
	       
	        for (RegistroVisita r : formularioDto.getRegistroVisitaList()) {
	            r.setFormulario(formulario);
	            registroVisitaRepository.save(r);
	        }

	        formularioRepository.save(formulario);

	        return "Formulário editado com sucesso!";
	    } catch (Exception e) {
	        return "Não foi possível editar o formulário";
	    }
	}


	@Transactional
	public String validarFormulario(Long idenFormulario, Long idenValidador) {
	    try {
	        Optional<Formulario> formularioOpt = formularioRepository.findById(idenFormulario);
	        if (!formularioOpt.isPresent()) {
	            return "Formulário não encontrado";
	        }

	        Optional<Pessoa> validadorOpt = pessoaRepository.findById(idenValidador);
	        if (!validadorOpt.isPresent()) {
	            return "Validador não encontrado";
	        }
	        
	        

	        Formulario formulario = formularioOpt.get();
	        
	        if(formulario.getSupervisor().getIdenPessoa() != idenValidador) {
	        	return "Atenção! O formulário deve ser validado apenas pelo supervisor cadastrado no formulário";
	        }
	        
	        
	        formulario.setFormularioValidado(true);
	        
	        formularioRepository.save(formulario);

	        return "Formulário validado com sucesso!";
	    } catch (Exception e) {
	        return "Não foi possível validar o formulário";
	    }
	}


	

}
