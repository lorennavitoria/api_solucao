package com.hackamt.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Formulario {
	//Dados gerais:
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idenFormulario;
	
	//Agente
	@ManyToOne
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;   
  
	@Column(name = "municipio", nullable = false, length = 100)
    private String municipio;
	
	@Column(name = "codigo_nome_localidade", nullable = false)
    private String codigoNomeLocalidade;

	@Column(name = "categoria", nullable = false, length = 50)
    private String categoria;

	@Column(name = "zona", nullable = false, length = 50)
	private String zona;
	
    @Column(name = "tipo_atividade", nullable = false)
    private String tipoAtividade;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "data_atividade", nullable = false)
    private LocalDate dataAtividade = LocalDate.now();
	
    @Column(name = "ciclo", nullable = false, length = 50)
    private String ciclo;
    
    @Column(name = "zona_concluida", nullable = false)
    private boolean zonaConcluida;
    
    
    //Resumo Trabalho de Campo
    
    @Column(name = "total_depositos")
    private Integer totalDepositos;
    
    @ManyToOne
   	@JoinColumn(name = "supervisor_id")
   	private Pessoa supervisor;
    
    
    //Resumo do Laboratório
    
    @Column(name= "numero_sequencia_quarteroes_aegypti")
    private String numeroSequenciaQuarteroes_aegypti;
    
    @Column(name= "numero_sequencia_quarteroes_albopictus")
    private String numeroSequenciaQuarteroes_albopictus;
	
 
    @Column(name = "formulario_validado", nullable = false)
    private boolean formularioValidado;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "formulario")
	private List<RegistroVisita> registroVisitas;


	public Long getIdenFormulario() {
		return idenFormulario;
	}

	public void setIdenFormulario(Long idenFormulario) {
		this.idenFormulario = idenFormulario;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<RegistroVisita> getRegistroVisitas() {
		return registroVisitas;
	}

	public void setRegistroVisitas(List<RegistroVisita> registroVisitas) {
		this.registroVisitas = registroVisitas;
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

	public LocalDate getDataAtividade() {
		return dataAtividade;
	}

	public void setDataAtividade(LocalDate dataAtividade) {
		this.dataAtividade = dataAtividade;
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

	public Pessoa getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Pessoa supervisor) {
		this.supervisor = supervisor;
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

	public boolean isFormularioValidado() {
		return formularioValidado;
	}

	public void setFormularioValidado(boolean formularioValidado) {
		this.formularioValidado = formularioValidado;
	}
	
	

}
