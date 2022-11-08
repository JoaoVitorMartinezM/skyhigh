package com.skyhigh.mdproduto.services;

import com.skyhigh.mdproduto.models.Produto;
import com.skyhigh.mdproduto.repositories.ProdutoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepo repositorio;





    public List<Produto> findAll() {
        return repositorio.findAll();
    }

    public Produto save(Produto produto) {

        return repositorio.save(produto);
    }

    public Produto edit(Long id, Produto produto) {
        if (repositorio.existsById(id)){
            Optional<Produto> p = repositorio.findById(id);
            Produto produtoEditado = p.get();
            produtoEditado.setNome(produto.getNome());
            produtoEditado.setPreco(produto.getPreco());
            produtoEditado.setDescricao(produto.getDescricao());
            produtoEditado.setUrlImagem(produto.getUrlImagem());

            repositorio.save(produtoEditado);


            return produtoEditado;
        }

        return null;
    }

    public boolean delete(Long id) {
        repositorio.deleteById(id);

        if (repositorio.existsById(id)) {
            return false;
        }
        return true;
    }
    public Produto getById(Long id){
        if (repositorio.existsById(id)) {
            Optional<Produto> p = repositorio.findById(id);
            Produto produto = p.get();
            return produto;
        }
        return null;

    }

}
