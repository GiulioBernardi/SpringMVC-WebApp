package br.com.bright.chefbot.usuario.repository;

import br.com.bright.chefbot.usuario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioReposiroty extends JpaRepository<Usuario, Long> {
}
