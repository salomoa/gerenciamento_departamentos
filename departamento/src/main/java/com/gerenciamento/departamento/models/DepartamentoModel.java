package com.gerenciamento.departamento.models;


import jakarta.persistence.*;

@Entity
@Table(name="TB_DEPARTAMENTO")
public class DepartamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    @Column(name = "nomeDepto")
    private String nome;
    @Column(name = "nomeLocalizacao")
    private String localizacao;

    public long getId() { return Id; }

    public void setId(long id) { Id = id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getLocalizacao() { return localizacao; }

    public void setLocalizacao(String localizacao) { this.localizacao = localizacao; }
}
