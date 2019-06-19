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

import br.ufjf.dcc193.trabalho2.model.Revisao;
import br.ufjf.dcc193.trabalho2.repository.RevisaoRepository;

@Service
public class RevisaoService {
    @Autowired
    private RevisaoRepository repository;

    public List<Revisao> findAll() {
        return repository.findAll();
    }

    public Revisao findOne(Long id) {
        return repository.getOne(id);
    }

    public Revisao save(Revisao revisao) {
        return repository.saveAndFlush(revisao);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
