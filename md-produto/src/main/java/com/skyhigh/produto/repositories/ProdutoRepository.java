package com.skyhigh.produto.repositories;

import com.skyhigh.produto.models.Produto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProdutoRepository {

    private static final List<Produto> PRODUTO_LIST = new ArrayList<>();

    public List<Produto> findAll(){
        return PRODUTO_LIST;
    }

    public Produto save(Produto produto){
        PRODUTO_LIST.add(produto);
        return produto;
    }

    public Produto findById(Integer id){
        for (Produto p:
                PRODUTO_LIST) {

            return p;
        }
        return null;
    }

    public Produto edit(Integer id, Produto produto){
        if (findById(id) != null){
            Produto produtoEditar = findById(id);

            return produtoEditar;
        }
        return null;

    }

    public boolean delete(Integer id){
        if (findById(id) != null){
            PRODUTO_LIST.remove(findById(id));
            return true;
        }
        return false;
    }
}
