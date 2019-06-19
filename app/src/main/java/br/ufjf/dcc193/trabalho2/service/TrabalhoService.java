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
package br.ufjf.dcc193.trabalho2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufjf.dcc193.trabalho2.model.Trabalho;
import br.ufjf.dcc193.trabalho2.repository.TrabalhoRepository;


@Service
public class TrabalhoService {
    @Autowired
    private TrabalhoRepository repository;

    public List<Trabalho> findAll() {
        return repository.findAll();
    }

    public Trabalho findOne(Long id) {
        return repository.getOne(id);
    }

    public Trabalho save(Trabalho trabalho) {
        return repository.saveAndFlush(trabalho);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
