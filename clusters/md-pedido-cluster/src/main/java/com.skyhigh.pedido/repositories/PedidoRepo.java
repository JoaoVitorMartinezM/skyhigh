package com.skyhigh.pedido.repositories;


import com.skyhigh.pedido.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepo extends JpaRepository<Pedido, Long> {
}
