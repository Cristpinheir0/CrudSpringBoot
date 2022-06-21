package com.cristpinheir0.site.model;

import javax.persistence.*;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Double valor;
    @Column(columnDefinition = "integer default 0")
    private Integer pp;
    @Column(columnDefinition = "integer default 0")
    private Integer p;
    @Column(columnDefinition = "integer default 0")
    private Integer m;
    @Column(columnDefinition = "integer default 0")
    private Integer g;
    @Column(columnDefinition = "integer default 0")
    private Integer gg;
    @Column(columnDefinition = "integer default 0")
    private Integer xg;

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

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getPp() {
        return pp;
    }

    public void setPp(Integer pp) {
        this.pp = pp;
    }

    public Integer getP() {
        return p;
    }

    public void setP(Integer p) {
        this.p = p;
    }

    public Integer getM() {
        return m;
    }

    public void setM(Integer m) {
        this.m = m;
    }

    public Integer getG() {
        return g;
    }

    public void setG(Integer g) {
        this.g = g;
    }

    public Integer getGg() {
        return gg;
    }

    public void setGg(Integer gg) {
        this.gg = gg;
    }

    public Integer getXg() {
        return xg;
    }

    public void setXg(Integer xg) {
        this.xg = xg;
    }

    public Item() {

    }

    public Item(String nome, Double valor, Integer pp, Integer p, Integer m, Integer g, Integer gg, Integer xg) {
        this.nome = nome;
        this.valor = valor;
        this.pp = pp;
        this.p = p;
        this.m = m;
        this.g = g;
        this.gg = gg;
        this.xg = xg;
    }
}
