package br.com.bright.chefbot.ingrediente.repository;

import br.com.bright.chefbot.ingrediente.model.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Long> {

    @Query("select i from Ingrediente i where LOWER(i.nome) like LOWER(concat(:termo, '%'))")
    public List<Ingrediente> findByNome(@Param("termo")String termo);


}
