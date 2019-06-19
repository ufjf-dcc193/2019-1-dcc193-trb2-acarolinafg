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

import br.ufjf.dcc193.trabalho2.model.AreaConhecimento;
import br.ufjf.dcc193.trabalho2.service.AreaConhecimentoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AreaConhecimentoController {

    @Autowired
    private AreaConhecimentoService service;

    @RequestMapping("/area-conhecimento")
    public String index(Model model) {
        model.addAttribute("areaConhecimento", service.findAll());
        return "area-conhecimento/index";
    }

    @RequestMapping("/area-conhecimento/create")
    public String criar(Model model) {
        model.addAttribute("areaConhecimento", new AreaConhecimento());
        return "area-conhecimento/create";
    }

    @RequestMapping("/area-conhecimento/store")
    public String store(AreaConhecimento areaConhecimento) {
        service.save(areaConhecimento);
        return "redirect:/area-conhecimento";
    }

    @RequestMapping("/area-conhecimento/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("areaConhecimento", service.findOne(id));
        return "area-conhecimento/edit";
    }

    @RequestMapping("/area-conhecimento/update/{id}")
    public String update(AreaConhecimento areaConhecimento) {
        service.save(areaConhecimento);
        return "redirect:/area-conhecimento";
    }

    @RequestMapping("/area-conhecimento/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        service.delete(id);
        return "redirect:/area-conhecimento";
    }
}
