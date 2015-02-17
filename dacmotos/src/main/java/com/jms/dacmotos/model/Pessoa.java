/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jms.dacmotos.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Moises
 */
@Entity
@Table(name = "tbl_pessoa")
public class Pessoa implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pes_id")
    private Long id;
    
    @Column(name = "pes_nome", length = 80, nullable = false)
    private String nome;
    
    @Column(name = "pes_cpf",unique = true, length = 14)
    private String cpf;
    
    @Column(name = "pes_rg",length = 12)
    private String rg;
    
    @Column(name = "pes_cnpj", length = 20, unique = true)
    private String cnpj;
    
    @Column(name = "pes_email", length = 100, unique = true)
    private String Email;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "pes_data_cadastro")
    private Date dataCadastro;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "pes_data_nascimento")
    private Date dataNascimento;
    
    @Column(name = "pes_telefone_residencial",length = 16)
    private String telefoneResidencial;
    
    @Column(name = "pes_telefone_celular", length = 16)
    private String telefoneCelular;
    
    @Column(name = "pes_telefone_recado", length = 16)
    private String telefoneRecado;
    
    @Column(name = "pes_nome_pessoa_recado")
    private String nomePessoaRecado;   
    
    @OneToMany(cascade = CascadeType.MERGE)
    private List<Endereco> enderecos;

    public Pessoa() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefoneResidencial() {
        return telefoneResidencial;
    }

    public void setTelefoneResidencial(String telefoneResidencial) {
        this.telefoneResidencial = telefoneResidencial;
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    public String getTelefoneRecado() {
        return telefoneRecado;
    }

    public void setTelefoneRecado(String telefoneRecado) {
        this.telefoneRecado = telefoneRecado;
    }

    public String getNomePessoaRecado() {
        return nomePessoaRecado;
    }

    public void setNomePessoaRecado(String nomePessoaRecado) {
        this.nomePessoaRecado = nomePessoaRecado;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return id.toString();
    }
    
    
    
    
}
