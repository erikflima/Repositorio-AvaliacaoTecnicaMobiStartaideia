package com.erik.projeto.controllers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erik.projeto.entities.Votacao;
import com.erik.projeto.repositories.VotacaoRepository;

@RestController
@RequestMapping(value="/api/votacao", produces="application/json")
public class VotacaoController {

	@Autowired 
	private VotacaoRepository votacaoRepository;
	
	
	private static final Logger log = LoggerFactory.getLogger( VotacaoController.class );
	
	
	public VotacaoController() {
		
	}

	

	@GetMapping(value = "/teste")
	public void teste() {
	
		
		System.out.println("\n\n\n Chegou no metodo ");
		Votacao votacao = new Votacao();
		
		
		votacao = votacaoRepository.findById(1);
		
		String resultado = votacao.toString();
		System.out.println(resultado);
	}	
	
	
}