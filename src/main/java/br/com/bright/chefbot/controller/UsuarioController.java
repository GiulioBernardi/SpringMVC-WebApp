package br.com.bright.chefbot.controller;

import br.com.bright.chefbot.repository.UsuarioReposiroty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioReposiroty reposiroty;

    @GetMapping("/usuario/listar")
    public String getUsuarios(Model model){
        model.addAttribute("listaUsuarios", reposiroty.findAll());
        return "usuarios/index";
    }

}
