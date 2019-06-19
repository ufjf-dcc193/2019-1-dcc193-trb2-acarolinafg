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

import br.ufjf.dcc193.trabalho2.model.Revisao;
import br.ufjf.dcc193.trabalho2.repository.AvaliadorRepository;
import br.ufjf.dcc193.trabalho2.repository.TrabalhoRepository;
import br.ufjf.dcc193.trabalho2.service.AreaConhecimentoService;
import br.ufjf.dcc193.trabalho2.service.AvaliadorService;
import br.ufjf.dcc193.trabalho2.service.RevisaoService;
import br.ufjf.dcc193.trabalho2.service.TrabalhoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RevisaoController {

    @Autowired
    private RevisaoService service;

    @Autowired
    private AreaConhecimentoService areaConhecimentoService;

    @Autowired
    private TrabalhoService trabalhoService;
    
    @Autowired
    private TrabalhoRepository trabalhoRepository;
    
    @Autowired
    private AvaliadorRepository avaliadorRepository;

    @Autowired
    private AvaliadorService avaliadorService;

    @RequestMapping("/revisao")
    public String index(Model model) {
        model.addAttribute("revisao", service.findAll());
        return "revisao/index";
    }

    @RequestMapping("/revisao/create")
    public String criar(Model model) {
        model.addAttribute("areaConhecimentoList", areaConhecimentoService.findAll());
        return "revisao/create";
    }

    @RequestMapping("/revisao/create/{id}")
    public String criar(Revisao revisao, @PathVariable Long id, Model model) {
        model.addAttribute("revisao", new Revisao());
        model.addAttribute("trabalho", trabalhoRepository.findByAreaConhecimento(areaConhecimentoService.findOne(id)));
        model.addAttribute("avaliador", avaliadorRepository.findByAreaConhecimento(areaConhecimentoService.findOne(id)));
        return "revisao/create2";
    }

    @RequestMapping("/revisao/store")
    public String store(Revisao revisao) {
        service.save(revisao);
        return "redirect:/revisao";
    }

    @RequestMapping("/revisao/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("revisao", service.findOne(id));
        return "revisao/edit";
    }

    @RequestMapping("/revisao/update")
    public String update(Revisao revisao) {
        service.save(revisao);
        return "redirect:/revisao";
    }

    @RequestMapping("/revisao/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        service.delete(id);
        return "redirect:/revisao";
    }

}
