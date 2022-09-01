package br.com.bright.chefbot.config;

import br.com.bright.chefbot.model.Usuario;
import br.com.bright.chefbot.repository.UsuarioReposiroty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class PopularBancoConfiguration implements CommandLineRunner {

    @Autowired
    private UsuarioReposiroty reposiroty;

    @Override
    public void run(String... args) throws Exception {
        Usuario u1 = new Usuario("Giulio", "giulio@gmail.com", "12345", "SP");
        Usuario u2 = new Usuario("Kaike", "kaike@gmail.com", "7777", "SP");
        Usuario u3 = new Usuario("Raissa", "raissa@gmail.com", "44444444", "SP");
        Usuario u4 = new Usuario("Andre", "andre@gmail.com", "123685545", "SP");
        reposiroty.saveAll(List.of(u1, u2, u3, u4));

    }
}
