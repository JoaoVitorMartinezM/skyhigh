package com.skyhigh.mdusuariocluster.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_usuario")
public class Usuario {

    @Id
    @Column(name = "login" , nullable = false, length = 15, unique = true)
    private String nome;
    @Column(nullable = false, length = 16)
    private String senha;


}
