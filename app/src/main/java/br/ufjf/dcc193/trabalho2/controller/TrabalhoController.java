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

import br.ufjf.dcc193.trabalho2.model.Trabalho;
import br.ufjf.dcc193.trabalho2.service.AreaConhecimentoService;
import br.ufjf.dcc193.trabalho2.service.TrabalhoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TrabalhoController {
    @Autowired
    private TrabalhoService service;
    
    @Autowired
    private AreaConhecimentoService areaConhecimentoService;
    
    @RequestMapping("/trabalho")
    public String index(Model model) {
        model.addAttribute("trabalho", service.findAll());
        return "trabalho/index";
    }

    @RequestMapping("/trabalho/create")
    public String criar(Model model) {
        model.addAttribute("trabalho", new Trabalho());
        model.addAttribute("areaConhecimentoList", areaConhecimentoService.findAll());
        return "trabalho/create";
    }

    @RequestMapping("/trabalho/store")
    public String store(Trabalho trabalho) {
        service.save(trabalho);
        return "redirect:/trabalho";
    }

    @RequestMapping("/trabalho/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("trabalho", service.findOne(id));
        model.addAttribute("areaConhecimentoList", areaConhecimentoService.findAll());
        return "trabalho/edit";
    }

    @RequestMapping("/trabalho/update/{id}")
    public String update(Trabalho trabalho) {
        service.save(trabalho);
        return "redirect:/trabalho";
    }

    @RequestMapping("/trabalho/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        service.delete(id);
        return "redirect:/trabalho";
    }
    
}
