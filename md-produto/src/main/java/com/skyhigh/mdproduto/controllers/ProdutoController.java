package com.skyhigh.mdproduto.controllers;

import com.skyhigh.mdproduto.models.Produto;
import com.skyhigh.mdproduto.services.ProdutoService;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Controller
@AllArgsConstructor
@RequestMapping(value = "/produto", name = "Produto")
public class ProdutoController {

    private ProdutoService service;

    @GetMapping(value = "/", name = "Produtos")
    public String recuperar(ModelMap model){
        List<Produto> produtos = service.findAll();
        model.addAttribute("produtos" , produtos);
        return "meus-produtos";
    }

    @GetMapping(value = "/pedidos", name = "Produtos")
    public String pedidos(){
        return "pedidos";
    }

    @GetMapping(value = "/home", name = "Produtos")
    public String home(ModelMap model){
        List<Produto> produtos = service.findAll();
        model.addAttribute("produtos" , produtos);
        return "home";
    }

    @GetMapping(value = "/form/edita/{id}", name = "Produtos")
    public String formularioEdicao(@PathVariable Long id, ModelMap model){
        Produto produto = service.getById(id);
        model.addAttribute("produto" , produto);
        return "edita-produto";
    }

    @GetMapping(value = "/id{id}", name = "Produtos")
    public Produto recuperarPorId(@RequestParam Long id){
        return service.getById(id);
    }

    @GetMapping(value = "/form", name = "Produtos")
    public String formulario(){
        return "cadastro-produto";
    }

    @PostMapping(value = "/novo", name = "NovoProduto")
    public String salvar(@RequestParam String nome,Double preco, String urlImagem, String descricao){
        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setPreco(preco);
        produto.setDescricao(descricao);
        produto.setUrlImagem(urlImagem);
        service.save(produto);
        return "cadastro-produto";
    }

    @PutMapping(value = "/edita/id{id}", name = "EditaProduto")
    public String editar(@RequestParam Long id, String nome,Double preco, String urlImagem, String descricao, ModelMap model){
        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setPreco(preco);
        produto.setDescricao(descricao);
        produto.setUrlImagem(urlImagem);
        service.edit(id, produto);

        List<Produto> produtos = service.findAll();
        model.addAttribute("produtos", produtos);

        return "meus-produtos";
    }

    @DeleteMapping(value = "/deleta/id{id}", name = "DeletaProduto")
    public String deletar(@RequestParam Long id, ModelMap model){
        service.delete(id);
        List<Produto> produtos = service.findAll();
        model.addAttribute("produtos" , produtos);

        return "meus-produtos";
    }


}
