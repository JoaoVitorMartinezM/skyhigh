package com.skyhigh.mdusuariocluster.repositories;


import com.skyhigh.mdusuariocluster.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepo extends JpaRepository<Usuario, String> {
}
