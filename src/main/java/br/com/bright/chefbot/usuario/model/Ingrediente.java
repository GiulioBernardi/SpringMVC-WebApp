package br.com.bright.chefbot.usuario.model;

import com.fasterxml.jackson.annotation.JsonRootName;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_ingrediente_bright")
@SequenceGenerator(name = "ingrediente", sequenceName = "SQ_TB_INGREDIENTE", allocationSize = 1)
@JsonRootName(value = "ingrediente")
public class Ingrediente {

    @Id
    @GeneratedValue(generator = "ingrediente", strategy = GenerationType.SEQUENCE)
    @Column(name = "cd_ingrediente")
    private Long id;

    @Column(name = "nm_ingrediente")
    @NotBlank(message = "O nome é um campo obrigatório")
    private String nome;

    @Column(name = "qtd_ingrediente")
    private Double quandidadeKg;

    @Column(name = "tp_ingrediente")
    @NotBlank(message = "O tipo é um campo obrigatório")
    private String tipo;

    @Column(name = "ds_marca_ingrediente")
    private String marca;

    public Ingrediente() {
    }

    public Ingrediente(String nome, Double quandidadeKg, String tipo, String marca) {
        this.nome = nome;
        this.quandidadeKg = quandidadeKg;
        this.tipo = tipo;
        this.marca = marca;
    }

    public Ingrediente(String nome, String tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public Ingrediente(String s) {

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

    public Double getQuandidadeKg() {
        return quandidadeKg;
    }

    public void setQuandidadeKg(Double quandidadeKg) {
        this.quandidadeKg = quandidadeKg;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
