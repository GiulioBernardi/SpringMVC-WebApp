package br.com.bright.chefbot.controller;

import br.com.bright.chefbot.model.Usuario;
import br.com.bright.chefbot.repository.UsuarioReposiroty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Optional;

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
    public String saveUsuario(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "usuarios/form";
        }
        reposiroty.save(usuario);
        return "redirect:/usuario/listar";
    }

    @GetMapping("/usuario/{id}")
    public String updateUsuario(@PathVariable("id") Long id, Model model){
        Optional<Usuario> usuarioDoBanco = reposiroty.findById(id);
        if(usuarioDoBanco.isEmpty()){
            throw new IllegalArgumentException("Usuário não encontrado");
        }
        model.addAttribute("usuario",usuarioDoBanco.get());
        return "usuarios/form";
    }

    @GetMapping("/usuario/excluir/{id}")
    public String deleteUsuarios(@PathVariable("id") Long id) {
        Optional<Usuario> usuarioDoBanco = reposiroty.findById(id);
        if (usuarioDoBanco.isEmpty()) {
            throw new IllegalArgumentException("Usuário não encontrado");
        }
        reposiroty.delete(usuarioDoBanco.get());
        return "redirect:/usuario/listar";
    }

}
