package br.com.bright.chefbot.config;

import br.com.bright.chefbot.ingrediente.model.Ingrediente;
import br.com.bright.chefbot.ingrediente.repository.IngredienteRepository;
import br.com.bright.chefbot.usuario.model.Usuario;
import br.com.bright.chefbot.usuario.repository.UsuarioReposiroty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class PopularBancoConfiguration implements CommandLineRunner {

    @Autowired
    private UsuarioReposiroty usuarioReposiroty;

    @Autowired
    private IngredienteRepository ingredienteRepository;

    @Override
    public void run(String... args) throws Exception {
        Ingrediente i1 = new Ingrediente("Arroz", "Ingrediente", 3.5);
        Ingrediente i2 = new Ingrediente("Cebolinha", "Tempero", 0.1);
        Ingrediente i3 = new Ingrediente("Alho", "Tempero", 0.05);
        Ingrediente i4 = new Ingrediente("Feijão", "Ingrediente", 2.5);
        ingredienteRepository.saveAll(List.of(i1, i2, i3, i4));

        Usuario u1 = new Usuario("Giulio", "giulio@gmail.com", "12345", "SP");
        u1.setIngredientes(List.of(i3));
        Usuario u2 = new Usuario("Kaike", "kaike@gmail.com", "7777", "SP");
//        u2.setIngredientes(List.of(i1, i4));
        Usuario u3 = new Usuario("Raissa", "raissa@gmail.com", "44444444", "SP");
//        u3.setIngredientes(List.of(i1, i2));
        Usuario u4 = new Usuario("Andre", "andre@gmail.com", "123685545", "SP");
//        u4.setIngredientes(List.of(i1, i2));
        usuarioReposiroty.saveAll(List.of(u1, u2, u3, u4));





    }
}
