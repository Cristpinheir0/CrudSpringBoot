package com.cristpinheir0.site.service;

import com.cristpinheir0.site.dto.ItemDto;
import com.cristpinheir0.site.dto.form.FormItem;
import com.cristpinheir0.site.model.Item;
import com.cristpinheir0.site.repository.ItemRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Page<ItemDto> lista(String nomeModelo,
                               @PageableDefault(sort = "id", direction = Sort.Direction.DESC,
                               page = 0, size = 10) Pageable paginacao){


        if(nomeModelo==null){
            Page<Item> itens = itemRepository.findAll(paginacao);
            return ItemDto.toItemDto(itens);
        }
        Page<Item> itens = itemRepository.findByNome(nomeModelo, paginacao);
        return ItemDto.toItemDto(itens);
    }

    public ResponseEntity<ItemDto> cadastrar(FormItem formItem, UriComponentsBuilder uriBuilder){
        Item item = formItem.toItem();

        itemRepository.save(item);

        URI uri = uriBuilder.path("/modelos/{id}").buildAndExpand(item.getId()).toUri();
        return ResponseEntity.created(uri).body(new ItemDto(item));
    }

    public ResponseEntity<ItemDto> atualizar(Long id, FormItem formItem) {
        Optional<Item> optionalItem = itemRepository.findById(id);
        if(optionalItem.isPresent()) {
            Item item = optionalItem.get();
            item.setNome(formItem.getNome());
            item.setValor(formItem.getValor());
            item.setPp(formItem.getPp());
            item.setP(formItem.getP());
            item.setM(formItem.getM());
            item.setG(formItem.getG());
            item.setGg(formItem.getGg());
            item.setXg(formItem.getXg());
            return ResponseEntity.ok(new ItemDto(item));
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<ItemDto> detalhar(Long id) {
        Optional<Item> item = itemRepository.findById(id);
        if(item.isPresent())
            return ResponseEntity.ok(new ItemDto(item.get()));

        return ResponseEntity.notFound().build();
    }

    public ResponseEntity remover(Long id) {
        if(itemRepository.findById(id).isPresent()) {
            itemRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
