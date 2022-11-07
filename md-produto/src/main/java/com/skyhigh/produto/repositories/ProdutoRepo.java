package com.skyhigh.produto.repositories;

import com.skyhigh.produto.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepo extends JpaRepository<Produto, Long> {
}
