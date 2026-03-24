package com.gerenciamento.departamento.models;


import jakarta.persistence.*;

@Entity
@Table(name="TB_DEPARTAMENTO")
public class DepartamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String nome;
    private String localizacao;

    public long getId() { return Id; }

    public void setId(long id) { Id = id; }

    @Column(name = "nomeDepto")
    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    @Column(name = "nomeLocalizacao")
    public String getLocalizacao() { return localizacao; }

    public void setLocalizacao(String localizacao) { this.localizacao = localizacao; }
}
