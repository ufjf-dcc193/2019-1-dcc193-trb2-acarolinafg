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
import javax.persistence.ManyToOne;

@Entity
public class Revisao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private int nota;
    private String descricao;
    private int status;

    @ManyToOne
    private Avaliador avaliador;

    @ManyToOne
    private Trabalho trabalho;

    public Revisao() {

    }

    public Revisao(Avaliador avaliador, Trabalho trabalho, int nota, String descricao, int status) {
        this.avaliador = avaliador;
        this.trabalho = trabalho;
        this.nota = nota;
        this.descricao = descricao;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Avaliador getAvaliador() {
        return avaliador;
    }

    public void setAvaliador(Avaliador avaliador) {
        this.avaliador = avaliador;
    }

    public Trabalho getTrabalho() {
        return trabalho;
    }

    public void setTrabalho(Trabalho trabalho) {
        this.trabalho = trabalho;
    }

    @Override
    public String toString() {
        return "{"
                + " id='" + getId() + "'"
                + ", avaliador='" + getAvaliador().toString() + "'"
                + ", trabalho='" + getTrabalho().toString() + "'"
                + ", nota='" + getNota() + "'"
                + ", descricao='" + getDescricao() + "'"
                + ", status='" + getStatus() + "'"
                + "}";
    }
}
