package br.com.bright.chefbot.ingrediente.model;

import br.com.bright.chefbot.usuario.model.Usuario;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_ingrediente")
@SequenceGenerator(name = "ingrediente", sequenceName = "SQ_TB_INGREDIENTE", allocationSize = 1)
public class Ingrediente {

    @Id
    @GeneratedValue(generator = "ingrediente", strategy = GenerationType.SEQUENCE)
    @Column(name = "cd_ingrediente")
    private long id;

    @Column(name = "nm_ingrediente")
    private String nome;

    @Column(name = "tp_ingrediente")
    private String tipo;


//    @OneToMany(cascade = CascadeType.ALL)
//    private List<Usuario> usuarios = new ArrayList<>();

    @ManyToOne
    private Usuario usuario;

    public Ingrediente() {
    }

    public Ingrediente(String nome, String tipo, Double quantidade) {
        this.nome = nome;
        this.tipo = tipo;
    }



    public Long getId() {
        return id;

    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }
}
