package com.erik.projeto.controllers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erik.projeto.entities.AssociadoVotacao;
import com.erik.projeto.repositories.AssociadoVotacaoRepository;

@RestController
@RequestMapping(value="/api/associadovotacao", produces="application/json")
public class AssociadoVotacaoController {

	@Autowired 
	private AssociadoVotacaoRepository associadoVotacaoRepository;
	
	
	private static final Logger log = LoggerFactory.getLogger( AssociadoVotacaoController.class );
	
	
	public AssociadoVotacaoController() {
		
	}

	

	@GetMapping(value = "/teste")
	public void teste() {
	
		
		System.out.println("\n\n\n Chegou no metodo ");
		AssociadoVotacao associadoVotacao = new AssociadoVotacao();
		
		
		associadoVotacao = associadoVotacaoRepository.findById(1);
		
		String resultado = associadoVotacao.toString();
		System.out.println(resultado);
	}	
	
	
}