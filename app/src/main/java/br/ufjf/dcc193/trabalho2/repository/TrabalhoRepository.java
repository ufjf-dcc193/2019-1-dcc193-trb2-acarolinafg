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
import org.springframework.data.jpa.repository.Query;

import br.ufjf.dcc193.trabalho2.model.AreaConhecimento;
import br.ufjf.dcc193.trabalho2.model.Trabalho;

public interface TrabalhoRepository extends JpaRepository<Trabalho, Long> {

    List<Trabalho> findByAreaConhecimento(AreaConhecimento areaConhecimento);

    @Query("SELECT trab FROM Trabalho trab"
            + " INNER JOIN Revisao as rev on rev.trabalho.id = trab.id "
            + " INNER JOIN Avaliador as ava on rev.avaliador.id = ava.id "
            + " WHERE ava.id = ?1 and trab.areaConhecimento.id = ?2 and rev.status = 1")
    List<Trabalho> findByIdAvalaliadorAndIdAreaConhecimentoOrderByStatus(Long idAvaliador, Long idArea);
}
