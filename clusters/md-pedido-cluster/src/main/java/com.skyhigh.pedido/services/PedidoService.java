package com.skyhigh.pedido.services;

import com.skyhigh.mdproduto.models.Produto;
import com.skyhigh.pedido.client.PedidoClient;
import com.skyhigh.pedido.repositories.PedidoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepo repositorio;

    @Autowired
    private PedidoClient request;




    public List<Produto> findAll() {


        return request.recuperar();
    }

    public Produto save(Produto produto) {

        return request.salvar(produto);
    }

    public Produto edit(Long id, Produto produto) {

            return request.editar(id, produto);
        }


    public boolean delete(Long id) {
        return request.deletar(id);
    }
    public Produto getById(Long id){

            return request.recuperarPorId(id);
        }

}
