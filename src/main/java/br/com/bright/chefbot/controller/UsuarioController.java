package br.com.bright.chefbot.controller;

import br.com.bright.chefbot.model.Usuario;
import br.com.bright.chefbot.repository.UsuarioReposiroty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioReposiroty reposiroty;

    @GetMapping("/usuario/listar")
    public String getUsuarios(Model model){
        model.addAttribute("listaUsuarios", reposiroty.findAll());
        return "usuarios/index";
    }

    @GetMapping("/usuario/novo")
    public String newUsuario(@ModelAttribute("usuario") Usuario usuario){
        return "usuarios/form";
    }

    @PostMapping("/usuarios/salvar")
    public String saveUsuario(@ModelAttribute("usuario") Usuario usuario){
        reposiroty.save(usuario);
        return "redirect:/usuarios";
    }

}
