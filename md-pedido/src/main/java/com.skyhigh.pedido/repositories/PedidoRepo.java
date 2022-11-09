package com.skyhigh.pedido.repositories;


import com.skyhigh.mdusuario.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepo extends JpaRepository<Usuario, String> {
}
