package br.com.bright.chefbot.usuario.controller;

import br.com.bright.chefbot.core.dto.AutoCompleteDTO;
import br.com.bright.chefbot.ingrediente.model.Ingrediente;
import br.com.bright.chefbot.ingrediente.repository.IngredienteRepository;
import br.com.bright.chefbot.usuario.model.Usuario;
import br.com.bright.chefbot.usuario.repository.UsuarioReposiroty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioReposiroty reposiroty;
    @Autowired
    private IngredienteRepository ingredienteRepository;

    private List<Ingrediente> ingredientesSugeridosAutoComplete = new ArrayList<>();

    @GetMapping("/usuario/listar")
    public String getUsuarios(Model model){
        model.addAttribute("listaUsuarios", reposiroty.findAll());
        return "usuarios/index";
    }

    @GetMapping("/usuario/novo")
    public String newUsuario(Model model){
        model.addAttribute("usuario", new Usuario(""));
        model.addAttribute("ingredientes", ingredienteRepository.findAll());
        return "usuarios/form";
    }

    @PostMapping("/usuarios/salvar")
    public String saveUsuario(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("ingredientes", ingredienteRepository.findAll());
            return "usuarios/form";
        }
        System.out.println(usuario.getNome());
        System.out.println(usuario.getUf());
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
        model.addAttribute("ingredientes", ingredienteRepository.findAll());
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

    @RequestMapping("/usuario/ingredientesNomeAutoComplete")
    @ResponseBody
    public List<AutoCompleteDTO> ingredientesNomeAutoComplete(@RequestParam(value="term", required = false, defaultValue="") String term) {
        List<AutoCompleteDTO> sugestoesDePreenchimento = new ArrayList<>();

        try {
            if (term.length() >= 2) {
                ingredientesSugeridosAutoComplete = ingredienteRepository.findByNome(term);
                for (Ingrediente ingrediente : ingredientesSugeridosAutoComplete) {
                    if (ingrediente.getNome().toLowerCase().contains(term.toLowerCase())) {
                        AutoCompleteDTO dto = new AutoCompleteDTO(ingrediente.getNome(), ingrediente.getId());
                        sugestoesDePreenchimento.add(dto);


                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(sugestoesDePreenchimento.get(0).getValue());
        return sugestoesDePreenchimento;

    }

}
