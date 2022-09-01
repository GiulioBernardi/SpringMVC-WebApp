package br.com.bright.chefbot.repository;

import br.com.bright.chefbot.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioReposiroty extends JpaRepository<Usuario, Long> {
}
