/** **********************************************************
 * Universidade Federal de Juiz de Fora - UFJF              *
 * Instituto de Ciências Exatas                             *
 * Departamento de Ciência da Computação                    *
 * Disciplina: DCC193 – Laboratório de Sistemas Web 2       *
 * Período: 2019-1                                          *
 * Professor: Igor Knop                                     *
 * Aluna: Ana Carolina Fidelis Gonçalves                    *
 *                                                          *
 *          TRABALHO 2 - Gestão de Pesquisas                *
 *********************************************************** */
package br.ufjf.dcc193.trabalho2.controller;

import br.ufjf.dcc193.trabalho2.model.Avaliador;
import br.ufjf.dcc193.trabalho2.model.Revisao;
import br.ufjf.dcc193.trabalho2.repository.RevisaoRepository;
import br.ufjf.dcc193.trabalho2.service.AreaConhecimentoService;
import br.ufjf.dcc193.trabalho2.service.AvaliadorService;
import br.ufjf.dcc193.trabalho2.service.RevisaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AvaliadorController {

    @Autowired
    private AvaliadorService service;

    @Autowired
    private AreaConhecimentoService areaConhecimentoService;

    @Autowired
    private RevisaoRepository revisaoRepository;

    @Autowired
    private RevisaoService revisaoService;

    @RequestMapping("/avaliador")
    public String index(Model model) {
        model.addAttribute("avaliador", service.findAll());
        return "avaliador/index";
    }

    @RequestMapping("/avaliador/create")
    public String criar(Model model) {
        model.addAttribute("avaliador", new Avaliador());
        model.addAttribute("areaConhecimentoList", areaConhecimentoService.findAll());
        return "avaliador/create";
    }

    @RequestMapping("/avaliador/store")
    public String store(Avaliador avaliador) {
        service.save(avaliador);
        return "redirect:/avaliador";
    }

    @RequestMapping("/avaliador/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("avaliador", service.findOne(id));
        model.addAttribute("areaConhecimentoList", areaConhecimentoService.findAll());
        return "avaliador/edit";
    }

    @RequestMapping("/avaliador/update")
    public String update(Avaliador avaliador) {
        service.save(avaliador);
        return "redirect:/avaliador";
    }

    @RequestMapping("/avaliador/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        service.delete(id);
        return "redirect:/avaliador";
    }

    @RequestMapping("/avaliador/{id}/revisoes")
    public String revisoes(@PathVariable("id") Long id, Model model) {
        Avaliador avaliador = service.findOne(id);
        model.addAttribute("revisoesList", revisaoRepository.findByAvaliador(avaliador.getId()));
        model.addAttribute("avaliador", avaliador);
        return "avaliador/list-revisoes-avaliado";
    }

    @RequestMapping("/avaliador/{id}/revisoes/status")
    public String upRevisoes(@PathVariable Long id, Revisao revisao) {
        revisaoService.save(revisao);
        return "redirect:/avaliador/" + id + "/revisoes";
    }
}
