package com.cristpinheir0.site.dto;

import com.cristpinheir0.site.model.Item;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class ItemDto {
    private Long id;
    private String nome;
    private Double valor;
    private Integer pp;
    private Integer p;
    private Integer m;
    private Integer g;
    private Integer gg;
    private Integer xg;

    public ItemDto(Item item){
        this.id = item.getId();
        this.nome = item.getNome();
        this.valor = item.getValor();
        this.pp = item.getPp();
        this.p = item.getP();
        this.m = item.getM();
        this.g = item.getG();
        this.gg = item.getGg();
        this.xg = item.getXg();
    }

    public static Page<ItemDto> toItemDto(Page<Item> itens) {
        return itens.map(ItemDto::new);
    }

    public Item toItem() {
        return new Item(this.nome, this.valor, this.pp, this.p, this.m, this.g, this.gg, this.xg);
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
