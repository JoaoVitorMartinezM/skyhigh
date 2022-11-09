package com.skyhigh.pedido.services;

import com.skyhigh.mdusuario.models.Usuario;
import com.skyhigh.mdusuario.repositories.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private UsuarioRepo repositorio;





    public List<Usuario> findAll() {
        return repositorio.findAll();
    }

    public Usuario save(Usuario usuario) {

        return repositorio.save(usuario);
    }

    public Usuario edit(String id, Usuario usuario) {

        if (repositorio.existsById(usuario.getNome())){
            Optional<Usuario> p = repositorio.findById(usuario.getNome());
            Usuario usuarioEditado = p.get();
            usuarioEditado.setNome(usuario.getNome());
            usuarioEditado.setSenha(usuario.getSenha());

            repositorio.save(usuarioEditado);

            return usuarioEditado;
        }

        return null;
    }

    public boolean delete(String id) {
        repositorio.deleteById(id);

        if (repositorio.existsById(id)) {
            return false;
        }
        return true;
    }
    public Usuario getById(String id){
        if (repositorio.existsById(id)) {
            Optional<Usuario> p = repositorio.findById(id);
            Usuario usuario = p.get();
            return usuario;
        }
        return null;

    }

}
