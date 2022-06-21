package com.cristpinheir0.site.repository;

import com.cristpinheir0.site.model.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    Page<Item> findByNome(String nomeModelo, Pageable paginacao);
}
