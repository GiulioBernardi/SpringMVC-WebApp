package br.com.bright.chefbot.config;


import br.com.bright.chefbot.usuario.model.Ingrediente;
import br.com.bright.chefbot.usuario.model.Usuario;
import br.com.bright.chefbot.usuario.repository.IngredienteRepository;
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
    private IngredienteRepository ingredienteRepository;


    @Override
    public void run(String... args) throws Exception {

        Ingrediente i1 = new Ingrediente("Orégano", 0.05, "Tempero", "Carrefour");
        Ingrediente i2 = new Ingrediente("Arroz", 0.5, "Grãos", "Carrefour");

        ingredienteRepository.saveAll(List.of(i1, i2));

    }
}
