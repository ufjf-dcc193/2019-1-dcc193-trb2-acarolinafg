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
import br.ufjf.dcc193.trabalho2.model.Trabalho;
import br.ufjf.dcc193.trabalho2.repository.AvaliadorRepository;
import br.ufjf.dcc193.trabalho2.repository.RevisaoRepository;
import br.ufjf.dcc193.trabalho2.repository.TrabalhoRepository;
import br.ufjf.dcc193.trabalho2.service.RevisaoService;
import br.ufjf.dcc193.trabalho2.service.TrabalhoService;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    AvaliadorRepository avaliadorRepository;

    @Autowired
    TrabalhoRepository trabalhoRepository;

    @Autowired
    private TrabalhoService trabalhoService;

    @Autowired
    RevisaoRepository revisaoRepository;
    
    @Autowired
    RevisaoService revisaoService;

    @RequestMapping("login")
    public String login(Model model, HttpSession session) {
        Avaliador userAvaliador = (Avaliador) session.getAttribute("userAvaliador");
        if (userAvaliador != null) {
            return "redirect:/login/home";
        }
        model.addAttribute("avaliador", new Avaliador());
        return "login/login";
    }

    @RequestMapping("login/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "index";
    }

    @RequestMapping("login/home")
    public String home(Model model, HttpSession session) {
        Avaliador userAvaliador = (Avaliador) session.getAttribute("userAvaliador");
        if (userAvaliador == null) {
            return "redirect:/login";
        }
        model.addAttribute("avaliador", userAvaliador);
        return "login/index";
    }

    @RequestMapping("login/signin")
    public String signin(Avaliador avaliador, HttpSession session) {
        Avaliador avaliadorUser = avaliadorRepository.findFirstByEmailAndSenha(avaliador.getEmail(), avaliador.getSenha());
        if (avaliadorUser != null) {
            session.setAttribute("userAvaliador", avaliadorUser);
            return "redirect:/login/home";
        } else {
            return "redirect:/";
        }
    }

    @RequestMapping("login/trabalhos/area/{id}")
    public String trabalhos(Model model, @PathVariable Long id, HttpSession session) {
        Avaliador userAvaliador = (Avaliador) session.getAttribute("userAvaliador");
        if (userAvaliador == null) {
            return "redirect:/login";
        }
        model.addAttribute("avaliador", userAvaliador);
        model.addAttribute("trabalhos", trabalhoRepository.findByIdAvalaliadorAndIdAreaConhecimentoOrderByStatus(userAvaliador.getId(), id));
        return "login/trabalhos";
    }

    @RequestMapping("login/avaliar/trabalho/{id}")
    public String avaliar(Model model, @PathVariable Long id, HttpSession session) {
        Avaliador userAvaliador = (Avaliador) session.getAttribute("userAvaliador");
        if (userAvaliador == null) {
            return "redirect:/login";
        }
        Trabalho trabalho = trabalhoService.findOne(id);
        Revisao revisao = revisaoRepository.findFirstByAvaliadorAndTrabalho(userAvaliador, trabalho);
        model.addAttribute("avaliador", userAvaliador);
        model.addAttribute("trabalho", trabalho);
        model.addAttribute("revisao", revisao);
        return "login/avaliar";
    }
    
    @RequestMapping("login/avaliar/update")
    public String save(@RequestParam("action") String tipoAcao, Revisao revisao, HttpSession session){
        Avaliador userAvaliador = (Avaliador) session.getAttribute("userAvaliador");
        if (userAvaliador == null) {
            return "redirect:/login";
        }
        
        switch (tipoAcao) {
            case "Revisar Depois":
                revisao.setStatus(0);
                break;
            case "Revisar Agora":
                revisao.setStatus(1);
                break;
            case "Pular":
                revisao.setStatus(2);
                break;
            default:
                break;
        }
        revisaoService.save(revisao);
        
        return "redirect:/login/home";
    }

}
