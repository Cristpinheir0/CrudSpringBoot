package com.cristpinheir0.site.controller;


import com.cristpinheir0.site.dto.ItemDto;
import com.cristpinheir0.site.dto.form.FormItem;
import com.cristpinheir0.site.service.ItemService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/modelos")
public class HomeController {

    private final ItemService itemService;

    public HomeController(ItemService itemService) {
        this.itemService = itemService;
    }

    //Método de get dos Itens
    @GetMapping
    @Cacheable(value = "listaDeModelos")
    public Page<ItemDto> lista(@RequestParam(required = false) String nomeModelo, Pageable paginacao){
        return this.itemService.lista(nomeModelo, paginacao);
    }

    //Método de criação de item
    @PostMapping
    @Transactional
    @CacheEvict(value = "listaDeModelos", allEntries = true)
    public ResponseEntity<ItemDto> cadastrar(@RequestBody @Valid FormItem formItem, UriComponentsBuilder uriBuilder){
        return this.itemService.cadastrar(formItem, uriBuilder);
    }


    //Método de get de um item
    @GetMapping("/{id}")
    public ResponseEntity<ItemDto> detalhar(@PathVariable Long id){
        return this.itemService.detalhar(id);
    }

    //Método de update do Item
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ItemDto> atualizar(@PathVariable Long id, @RequestBody @Valid FormItem formItem){
        return this.itemService.atualizar(id, formItem);
    }

    //Método de exclusão de Item
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity remover(@PathVariable Long id) {
        return this.itemService.remover(id);
    }

}
