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
package br.ufjf.dcc193.trabalho2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufjf.dcc193.trabalho2.model.AreaConhecimento;
import br.ufjf.dcc193.trabalho2.model.Avaliador;

public interface AvaliadorRepository extends JpaRepository<Avaliador, Long> {

    Avaliador findFirstByEmailAndSenha(String email, String senha);

    List<Avaliador> findByAreaConhecimento(AreaConhecimento areaConhecimento);
}
