package com.projetobanco.bancoOnline.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetobanco.bancoOnline.entidades.Cliente;
import com.projetobanco.bancoOnline.entidades.Conta;
import com.projetobanco.bancoOnline.repositorio.ContaRepositorio;

@RestController
@RequestMapping(value = "/contas")
public class ContaController {
 
	@Autowired
	private ContaRepositorio repositorio;
	
	@GetMapping
	public List<Conta> FindAll(){
		List<Conta> resultadoQuery = repositorio.findAll();
		return resultadoQuery;
	}
	
}
