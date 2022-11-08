package com.skyhigh.mdproduto.repositories;

import com.skyhigh.mdproduto.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepo extends JpaRepository<Produto, Long> {
}
