package com.skyhigh.mdusuario.repositories;


import com.skyhigh.mdusuario.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepo extends JpaRepository<Usuario, String> {
}
