package com.hackamt.model;

import java.time.LocalDateTime;
import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idenPessoa;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(nullable = false, unique = true)
    private String email;

    private String telefone;

    private String endereco;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private boolean ativo = true;
    
    @Column()
    private Long tipoPessoa;

    @Column()
    private LocalDateTime dataCadastro = LocalDateTime.now();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoa")
	private List<Formulario> formulariosLista;
    
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoa")
	private List<Formulario> formulariosListaSupervisor;

    // Construtor padrão
    public Pessoa() {
    }

   


    public Pessoa(Long idenPessoa, String nome, String cpf, String email, String telefone, String endereco,
			String senha, boolean ativo, Long tipoPessoa, LocalDateTime dataCadastro, List<Formulario> formulariosLista,
			List<Formulario> formulariosListaSupervisor) {
		super();
		this.idenPessoa = idenPessoa;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
		this.senha = senha;
		this.ativo = ativo;
		this.tipoPessoa = tipoPessoa;
		this.dataCadastro = dataCadastro;
		this.formulariosLista = formulariosLista;
		this.formulariosListaSupervisor = formulariosListaSupervisor;
	}




	public Long getIdenPessoa() {
		return idenPessoa;
	}

	public void setIdenPessoa(Long idenPessoa) {
		this.idenPessoa = idenPessoa;
	}

	public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

	public List<Formulario> getFormulariosLista() {
		return formulariosLista;
	}

	public void setFormulariosLista(List<Formulario> formulariosLista) {
		this.formulariosLista = formulariosLista;
	}

	public List<Formulario> getFormulariosListaSupervisor() {
		return formulariosListaSupervisor;
	}

	public void setFormulariosListaSupervisor(List<Formulario> formulariosListaSupervisor) {
		this.formulariosListaSupervisor = formulariosListaSupervisor;
	}

	public Long getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(Long tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

 
}
