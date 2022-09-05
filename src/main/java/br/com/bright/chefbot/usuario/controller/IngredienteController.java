package br.com.bright.chefbot.usuario.controller;

import br.com.bright.chefbot.usuario.model.Ingrediente;
import br.com.bright.chefbot.usuario.repository.IngredienteRepository;
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
public class IngredienteController {

    @Autowired
    private IngredienteRepository repository;

    @GetMapping("/ingrediente/listar")
    public String getIngredientes(Model model){
        model.addAttribute("listaIngredientes", repository.findAll());
        return "ingredientes/index";
    }

    @GetMapping("/ingrediente/novo")
    public String newUsuario(Model model){
        model.addAttribute("ingrediente", new Ingrediente(""));
        return "ingredientes/form";
    }

    @PostMapping("/ingrediente/salvar")
    public String saveIngrediente(@Valid @ModelAttribute("ingrediente") Ingrediente ingrediente, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "ingredientes/form";
        }

        repository.save(ingrediente);
        return "redirect:/ingrediente/listar";
    }

    @GetMapping("/ingrediente/{id}")
    public String updateIngrediente(@PathVariable("id") Long id, Model model){
        Optional<Ingrediente> ingredienteDoBanco = repository.findById(id);
        if(ingredienteDoBanco.isEmpty()){
            throw new IllegalArgumentException("Ingrediente não encontrado");
        }
        model.addAttribute("ingrediente",ingredienteDoBanco.get());
        return "ingredientes/form";
    }

    @GetMapping("/ingrediente/excluir/{id}")
    public String deleteIngredinetes(@PathVariable("id") Long id) {
        Optional<Ingrediente> ingredienteDoBanco = repository.findById(id);
        if (ingredienteDoBanco.isEmpty()) {
            throw new IllegalArgumentException("Ingrediente não encontrado");
        }
        repository.delete(ingredienteDoBanco.get());
        return "redirect:/ingrediente/listar";
    }
}