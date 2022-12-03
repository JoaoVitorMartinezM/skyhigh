package com.skyhigh.pedido.controllers;


import com.skyhigh.mdproduto.models.Produto;
import com.skyhigh.pedido.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping(value = "/pedido", name = "pedido")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @GetMapping(value = "/", name = "Pedidos")
    public List<Produto> recuperar(){
        List<Produto> produtosPedido = service.findAll();

        return service.findAll();
    }

    @GetMapping(value = "/id{id}", name = "Pedidos")
    public Produto recuperarPorId(@RequestParam Long id){
        return service.getById(id);
    }

    @PostMapping(value = "/novo", name = "NovoPedido")
    public Produto salvar(@RequestBody Produto produto){
        return service.save(produto);
    }

    @PutMapping(value = "/edita/id{id}", name = "EditaPedido")
    public Produto editar(@RequestParam Long id, @RequestBody Produto produto){
        return service.edit(id, produto);
    }


    @DeleteMapping(value = "/deleta/id{id}", name = "DeletaPedido")
    public boolean deletar(@RequestParam Long id){
        return service.delete(id);
    }

}
