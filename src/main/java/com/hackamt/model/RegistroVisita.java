package com.hackamt.model;

import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class RegistroVisita {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idenRegistroVisita;
	
	
	@ManyToOne
	@JoinColumn(name = "formulario_id")
	private Formulario formulario;
	
	
	@Column(name = "numero_quarteirao")
    private Integer numeroQuarteirao;

    @Column(name = "sequencial")
    private boolean sequencial;

    @Column(name = "lado")
    private boolean lado;

    @Column(name = "rua", length = 100)
    private String rua;

    @Column(name = "numero")
    private Integer numero;
	
    @Column(name = "sequencia")
    private boolean sequencia;

    @Column(name = "complemento", length = 100)
    private String complemento;

    @Column(name = "tipo_imovel", nullable = false)
    private String tipoImovel;
    
    @JsonFormat(pattern = "HH:mm")
    @Column(name = "hora_entrada")
    private LocalTime horaEntrada;

    @Column(name = "visita_normal_recuperacao")
    private boolean visitaNormalRecuperacao;

    @Column(name = "pendencia_recusa_fechada", length = 2)
    private String pendenciaRecusaFechada;
    
 // Depósitos Inspecionados
    @Column(name = "a1")
    private Integer a1;

    @Column(name = "a2")
    private Integer a2;

    @Column(name = "b")
    private Integer b;
    
    @Column(name = "imovel_inspecionado")
    private boolean imovelInspecionado;

    // Coleta Amostra
    @Column(name = "numero_amostra_inicial")
    private String numeroAmostraInicial;

    @Column(name = "numero_amostra_final")
    private String numeroAmostraFinal;

    @Column(name = "total_amostras")
    private Integer totalAmostras;

    // Tratamento Focal - Larvicida
    @Column(name = "imovel_tratado_focal")
    private boolean imovelTratadoFocal;
    
    @Column(name = "tipo_larvicida1", length = 50)
    private String tipoLarvicida1;

    @Column(name = "qtd_larvicida1_gramas")
    private Double qtdLarvicida1Gramas;

    @Column(name = "qtd_dep_tratados1")
    private Integer qtdDepTratados1;
	


	public Long getIdenRegistroVisita() {
		return idenRegistroVisita;
	}


	public void setIdenRegistroVisita(Long idenRegistroVisita) {
		this.idenRegistroVisita = idenRegistroVisita;
	}


	public Formulario getFormulario() {
		return formulario;
	}


	public void setFormulario(Formulario formulario) {
		this.formulario = formulario;
	}


	public Integer getNumeroQuarteirao() {
		return numeroQuarteirao;
	}


	public void setNumeroQuarteirao(Integer numeroQuarteirao) {
		this.numeroQuarteirao = numeroQuarteirao;
	}


	public boolean isSequencial() {
		return sequencial;
	}


	public void setSequencial(boolean sequencial) {
		this.sequencial = sequencial;
	}


	public boolean isLado() {
		return lado;
	}


	public void setLado(boolean lado) {
		this.lado = lado;
	}


	public String getRua() {
		return rua;
	}


	public void setRua(String rua) {
		this.rua = rua;
	}


	public Integer getNumero() {
		return numero;
	}


	public void setNumero(Integer numero) {
		this.numero = numero;
	}


	public boolean isSequencia() {
		return sequencia;
	}


	public void setSequencia(boolean sequencia) {
		this.sequencia = sequencia;
	}


	public String getComplemento() {
		return complemento;
	}


	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}


	public String getTipoImovel() {
		return tipoImovel;
	}


	public void setTipoImovel(String tipoImovel) {
		this.tipoImovel = tipoImovel;
	}


	public LocalTime getHoraEntrada() {
		return horaEntrada;
	}


	public void setHoraEntrada(LocalTime horaEntrada) {
		this.horaEntrada = horaEntrada;
	}


	public boolean isVisitaNormalRecuperacao() {
		return visitaNormalRecuperacao;
	}


	public void setVisitaNormalRecuperacao(boolean visitaNormalRecuperacao) {
		this.visitaNormalRecuperacao = visitaNormalRecuperacao;
	}


	public String getPendenciaRecusaFechada() {
		return pendenciaRecusaFechada;
	}


	public void setPendenciaRecusaFechada(String pendenciaRecusaFechada) {
		this.pendenciaRecusaFechada = pendenciaRecusaFechada;
	}


	public Integer getA1() {
		return a1;
	}


	public void setA1(Integer a1) {
		this.a1 = a1;
	}


	public Integer getA2() {
		return a2;
	}


	public void setA2(Integer a2) {
		this.a2 = a2;
	}


	public Integer getB() {
		return b;
	}


	public void setB(Integer b) {
		this.b = b;
	}


	public boolean isImovelInspecionado() {
		return imovelInspecionado;
	}


	public void setImovelInspecionado(boolean imovelInspecionado) {
		this.imovelInspecionado = imovelInspecionado;
	}


	public String getNumeroAmostraInicial() {
		return numeroAmostraInicial;
	}


	public void setNumeroAmostraInicial(String numeroAmostraInicial) {
		this.numeroAmostraInicial = numeroAmostraInicial;
	}


	public String getNumeroAmostraFinal() {
		return numeroAmostraFinal;
	}


	public void setNumeroAmostraFinal(String numeroAmostraFinal) {
		this.numeroAmostraFinal = numeroAmostraFinal;
	}


	public Integer getTotalAmostras() {
		return totalAmostras;
	}


	public void setTotalAmostras(Integer totalAmostras) {
		this.totalAmostras = totalAmostras;
	}


	public boolean isImovelTratadoFocal() {
		return imovelTratadoFocal;
	}


	public void setImovelTratadoFocal(boolean imovelTratadoFocal) {
		this.imovelTratadoFocal = imovelTratadoFocal;
	}


	public String getTipoLarvicida1() {
		return tipoLarvicida1;
	}


	public void setTipoLarvicida1(String tipoLarvicida1) {
		this.tipoLarvicida1 = tipoLarvicida1;
	}


	public Double getQtdLarvicida1Gramas() {
		return qtdLarvicida1Gramas;
	}


	public void setQtdLarvicida1Gramas(Double qtdLarvicida1Gramas) {
		this.qtdLarvicida1Gramas = qtdLarvicida1Gramas;
	}


	public Integer getQtdDepTratados1() {
		return qtdDepTratados1;
	}


	public void setQtdDepTratados1(Integer qtdDepTratados1) {
		this.qtdDepTratados1 = qtdDepTratados1;
	}
	
	
	
}
