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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Trabalho implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String titulo;
    private String descricao;
    private String url;

    @OneToOne
    private AreaConhecimento areaConhecimento;

    public Trabalho() {

    }

    public Trabalho(Long id, String titulo, String descricao, String url, AreaConhecimento areaConhecimento) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.url = url;
        this.areaConhecimento = areaConhecimento;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public AreaConhecimento getAreaConhecimento() {
        return this.areaConhecimento;
    }

    public void setAreaConhecimento(AreaConhecimento areaConhecimento) {
        this.areaConhecimento = areaConhecimento;
    }

    public Trabalho id(Long id) {
        this.id = id;
        return this;
    }

    public Trabalho titulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public Trabalho descricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public Trabalho url(String url) {
        this.url = url;
        return this;
    }

    public Trabalho areaConhecimento(AreaConhecimento areaConhecimento) {
        this.areaConhecimento = areaConhecimento;
        return this;
    }

    @Override
    public String toString() {
        return "{"
                + " id='" + getId() + "'"
                + ", titulo='" + getTitulo() + "'"
                + ", descricao='" + getDescricao() + "'"
                + ", url='" + getUrl() + "'"
                + ", areaConhecimento='" + getAreaConhecimento() + "'"
                + "}";
    }

}
