package com.projetobanco.bancoOnline.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetobanco.bancoOnline.entidades.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente, String>{

}
