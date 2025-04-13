package com.hackamt.model.dto;

import java.time.LocalTime;
import java.util.List;

import com.hackamt.model.Pessoa;
import com.hackamt.model.RegistroVisita;

public class FormularioDto {
	
	
	//Cadastro model Formulario
	private Long idenFormulario;
	private Long idenPessoa;
	private String municipio;
	private String codigoNomeLocalidade;
	private String categoria;
	private String zona;
	private String tipoAtividade;
	private String ciclo;
	private boolean zonaConcluida;
	private Integer totalDepositos;
	private Long idenSupervisor;//Tipo Pessoa
	private String numeroSequenciaQuarteroes_aegypti;
	private String numeroSequenciaQuarteroes_albopictus;
	
	//Lista de RegistroVisita
	List<RegistroVisita> registroVisitaList;
	
	


	public FormularioDto() {
		super();
	}




	public FormularioDto(Long idenFormulario, Long idenPessoa, String municipio, String codigoNomeLocalidade,
			String categoria, String zona, String tipoAtividade, String ciclo, boolean zonaConcluida,
			Integer totalDepositos, Long idenSupervisor, String numeroSequenciaQuarteroes_aegypti,
			String numeroSequenciaQuarteroes_albopictus, List<RegistroVisita> registroVisitaList) {
		super();
		this.idenFormulario = idenFormulario;
		this.idenPessoa = idenPessoa;
		this.municipio = municipio;
		this.codigoNomeLocalidade = codigoNomeLocalidade;
		this.categoria = categoria;
		this.zona = zona;
		this.tipoAtividade = tipoAtividade;
		this.ciclo = ciclo;
		this.zonaConcluida = zonaConcluida;
		this.totalDepositos = totalDepositos;
		this.idenSupervisor = idenSupervisor;
		this.numeroSequenciaQuarteroes_aegypti = numeroSequenciaQuarteroes_aegypti;
		this.numeroSequenciaQuarteroes_albopictus = numeroSequenciaQuarteroes_albopictus;
		this.registroVisitaList = registroVisitaList;
	}




	public Long getIdenFormulario() {
		return idenFormulario;
	}




	public void setIdenFormulario(Long idenFormulario) {
		this.idenFormulario = idenFormulario;
	}




	public Long getIdenPessoa() {
		return idenPessoa;
	}




	public void setIdenPessoa(Long idenPessoa) {
		this.idenPessoa = idenPessoa;
	}




	public String getMunicipio() {
		return municipio;
	}




	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}




	public String getCodigoNomeLocalidade() {
		return codigoNomeLocalidade;
	}




	public void setCodigoNomeLocalidade(String codigoNomeLocalidade) {
		this.codigoNomeLocalidade = codigoNomeLocalidade;
	}




	public String getCategoria() {
		return categoria;
	}




	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}




	public String getZona() {
		return zona;
	}




	public void setZona(String zona) {
		this.zona = zona;
	}




	public String getTipoAtividade() {
		return tipoAtividade;
	}




	public void setTipoAtividade(String tipoAtividade) {
		this.tipoAtividade = tipoAtividade;
	}




	public String getCiclo() {
		return ciclo;
	}




	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}




	public boolean isZonaConcluida() {
		return zonaConcluida;
	}




	public void setZonaConcluida(boolean zonaConcluida) {
		this.zonaConcluida = zonaConcluida;
	}




	public Integer getTotalDepositos() {
		return totalDepositos;
	}




	public void setTotalDepositos(Integer totalDepositos) {
		this.totalDepositos = totalDepositos;
	}




	public Long getIdenSupervisor() {
		return idenSupervisor;
	}




	public void setIdenSupervisor(Long idenSupervisor) {
		this.idenSupervisor = idenSupervisor;
	}




	public String getNumeroSequenciaQuarteroes_aegypti() {
		return numeroSequenciaQuarteroes_aegypti;
	}




	public void setNumeroSequenciaQuarteroes_aegypti(String numeroSequenciaQuarteroes_aegypti) {
		this.numeroSequenciaQuarteroes_aegypti = numeroSequenciaQuarteroes_aegypti;
	}




	public String getNumeroSequenciaQuarteroes_albopictus() {
		return numeroSequenciaQuarteroes_albopictus;
	}




	public void setNumeroSequenciaQuarteroes_albopictus(String numeroSequenciaQuarteroes_albopictus) {
		this.numeroSequenciaQuarteroes_albopictus = numeroSequenciaQuarteroes_albopictus;
	}




	public List<RegistroVisita> getRegistroVisitaList() {
		return registroVisitaList;
	}




	public void setRegistroVisitaList(List<RegistroVisita> registroVisitaList) {
		this.registroVisitaList = registroVisitaList;
	}
	
	
	
	
	
	
	
}
