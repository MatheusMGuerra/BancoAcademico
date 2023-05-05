package com.projetobanco.bancoOnline.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetobanco.bancoOnline.entidades.Cliente;
import com.projetobanco.bancoOnline.entidades.Conta;
import com.projetobanco.bancoOnline.repositorio.ClienteRepositorio;
import com.projetobanco.bancoOnline.repositorio.ContaRepositorio;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepositorio repositorio;
	@Autowired
	private ContaRepositorio repositorioConta;
	
	@GetMapping
	public List<Cliente> FindAll(){
		List<Cliente> resultadoQuery = repositorio.findAll();
		return resultadoQuery;
	}
	
	@GetMapping(value = "/{cpf}")
	public Cliente FindByCpf(@PathVariable String cpf){
		Cliente resultadoQuery = repositorio.findById(cpf).get();
		return resultadoQuery;
	}
	
	@PostMapping
	public Cliente AddCliente(@RequestBody Cliente cliente){
		/* Após inserir um novo cliente e repetir algum dos métodos find acima, a conta do objeto cliente
		 * retornava "null", mas quando fiz uma verificação listando as contas salvas no banco,
		 * a conta havia persistido. Como solução, estou setando a conta
		 * do cliente que vem como parâmetro desse método numa variável do tipo conta. Depois, seto esse
		 * cliente no atributo cliente lá da classe conta. Após isso, salvo o objeto do método no banco
		 * e seto novamente a conta nesse cliente.*/
		Conta conta = cliente.getConta();
		conta.setCliente(cliente);
		Cliente resultadoQuery = repositorio.save(cliente);
		cliente.setConta(conta);
		return resultadoQuery;
	}
	
	@DeleteMapping(value = "/{cpf}")
	public void ExcluirCliente(@PathVariable String cpf) {
		repositorio.deleteById(cpf);
	}
	
}
