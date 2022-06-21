package com.cristpinheir0.site.dto.form;

import com.cristpinheir0.site.model.Item;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class FormItem {

    @NotBlank
    private String nome;
    @NotNull
    private Double valor;
    private Integer pp;
    private Integer p;
    private Integer m;
    private Integer g;
    private Integer gg;
    private Integer xg;

    public Item toItem() {
        return new Item(this.nome, this.valor, this.pp, this.p, this.m, this.g, this.gg, this.xg);
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
}
