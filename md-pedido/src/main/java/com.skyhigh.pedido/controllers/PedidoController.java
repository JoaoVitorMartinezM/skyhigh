package com.skyhigh.pedido.controllers;


import com.skyhigh.mdusuario.models.Usuario;
import com.skyhigh.mdusuario.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/usuario", name = "Pedido")
public class PedidoController {

    @Autowired
    private UsuarioService service;

    @GetMapping(value = "/", name = "Usuarios")
    public List<Usuario> get(){
        return service.findAll();
    }

    @GetMapping(value = "/{id}", name = "Usuarios")
    public Usuario getById(@RequestParam String id){
        return service.getById(id);
    }

    @PostMapping(value = "/novo", name = "NovoUsuario")
    public Usuario post(@RequestBody Usuario usuario){
        return service.save(usuario);
    }

    @PutMapping(value = "/edita/{id}", name = "EditaUsuario")
    public Usuario put(@RequestBody Usuario usuario){
        return service.edit(usuario.getNome(), usuario);
    }

    @DeleteMapping(value = "/deleta/{id}", name = "DeletaUsuario")
    public boolean delete(@RequestParam String id){
        return service.delete(id);
    }
}
