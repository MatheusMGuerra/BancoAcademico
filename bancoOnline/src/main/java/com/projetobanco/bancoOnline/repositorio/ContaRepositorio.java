package com.projetobanco.bancoOnline.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetobanco.bancoOnline.entidades.Conta;

public interface ContaRepositorio extends JpaRepository<Conta, Long>{

}
