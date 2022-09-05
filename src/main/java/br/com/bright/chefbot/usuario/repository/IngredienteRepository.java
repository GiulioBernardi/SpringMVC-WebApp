package br.com.bright.chefbot.usuario.repository;

import br.com.bright.chefbot.usuario.model.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Long> {
}
