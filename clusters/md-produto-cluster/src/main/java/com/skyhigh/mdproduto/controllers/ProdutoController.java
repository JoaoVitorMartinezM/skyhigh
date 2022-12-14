package com.skyhigh.mdproduto.controllers;

import com.skyhigh.mdproduto.models.Produto;
import com.skyhigh.mdproduto.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/produto", name = "Produto")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping(value = "/", name = "Produtos")
    public List<Produto> recuperar(){
        return service.findAll();
    }

    @GetMapping(value = "/{id}", name = "Produtos")
    public Produto recuperarPorId(@RequestParam Long id){
        return service.getById(id);
    }

    @PostMapping(value = "/novo", name = "NovoProduto")
    public Produto salvar(@RequestBody Produto produto){
        return service.save(produto);
    }

    @PutMapping(value = "/edita/{id}", name = "EditaProduto")
    public Produto editar(@RequestParam Long id, @RequestBody Produto produto){
        return service.edit(id, produto);
    }

    @DeleteMapping(value = "/deleta/{id}", name = "DeletaProduto")
    public boolean deletar(@RequestParam Long id){
        return service.delete(id);
    }
}
