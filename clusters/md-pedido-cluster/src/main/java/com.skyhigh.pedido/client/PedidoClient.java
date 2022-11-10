package com.skyhigh.pedido.client;

import com.skyhigh.mdproduto.models.Produto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("produto")
public interface PedidoClient {

    @GetMapping(value = "/produto/")
    List<Produto> recuperar();

    @GetMapping(value = "/produto/{id}", name = "Produtos")
    Produto recuperarPorId(@RequestParam Long id);

    @PostMapping(value = "/produto/novo", name = "NovoProduto")
    Produto salvar(@RequestBody Produto produto);

    @PutMapping(value = "/produto/edita/{id}", name = "EditaProduto")
    Produto editar(@RequestParam Long id, @RequestBody Produto produto);

    @DeleteMapping(value = "/produto/deleta/{id}", name = "DeletaProduto")
    boolean deletar(@RequestParam Long id);


}
