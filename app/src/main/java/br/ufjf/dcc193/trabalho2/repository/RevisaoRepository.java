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

import br.ufjf.dcc193.trabalho2.model.Revisao;
import br.ufjf.dcc193.trabalho2.model.Trabalho;
import br.ufjf.dcc193.trabalho2.model.Avaliador;

public interface RevisaoRepository extends JpaRepository<Revisao, Long> {

    Revisao findFirstByAvaliadorAndTrabalho(Avaliador avaliador, Trabalho trabalho);

    @Query("SELECT rev FROM Revisao rev"
            + " INNER JOIN Avaliador as ava on rev.avaliador.id = ava.id "
            + " WHERE ava.id = ?1 and rev.status = 1")
    List<Revisao> findByAvaliador(Long long1);
}
