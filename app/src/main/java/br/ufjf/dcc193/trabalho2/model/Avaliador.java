/** **********************************************************
 * Universidade Federal de Juiz de Fora - UFJF              *
 * Instituto de Ciências Exatas                             *
 * Departamento de Ciência da Computação                    *
 * Disciplina: DCC193 – Laboratório de Sistemas Web 2       *
 * Período: 2019-1                                          *
 * Professor: Igor Knop                                     *
 * Aluna: Ana Carolina Fidelis Gonçalves                    *
 *                                                          *
 *          TRABALHO 2 - Gestão de Pesquiuisas              *
 *********************************************************** */
package br.ufjf.dcc193.trabalho2.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Entity;
import javax.persistence.FetchType;

@Entity
public class Avaliador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    private String email;
    private String senha;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<AreaConhecimento> areaConhecimento;

    public Avaliador() {
    }

    public Avaliador(Long id, String nome, String email, String senha, List<AreaConhecimento> areaConhecimento) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.areaConhecimento = areaConhecimento;

    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<AreaConhecimento> getAreaConhecimento() {
        return this.areaConhecimento;
    }

    public void setAreaConhecimento(List<AreaConhecimento> areaConhecimento) {
        this.areaConhecimento = areaConhecimento;
    }

    public Avaliador id(Long id) {
        this.id = id;
        return this;
    }

    public Avaliador nome(String nome) {
        this.nome = nome;
        return this;
    }

    public Avaliador email(String email) {
        this.email = email;
        return this;
    }

    public Avaliador senha(String senha) {
        this.senha = senha;
        return this;
    }

    public Avaliador areaConhecimento(List<AreaConhecimento> areaConhecimento) {
        this.areaConhecimento = areaConhecimento;
        return this;
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", nome='" + getNome() + "'" + ", email='" + getEmail() + "'"
                + ", senha='" + getSenha() + "'" + ", areaConhecimento='" + getAreaConhecimento() + "'"
                + "}";
    }

}
