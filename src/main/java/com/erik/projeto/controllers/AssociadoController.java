package com.erik.projeto.controllers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erik.projeto.entities.Associado;
import com.erik.projeto.repositories.AssociadoRepository;

@RestController
@RequestMapping(value="/api/associado", produces="application/json")
public class AssociadoController {

	@Autowired 
	private AssociadoRepository associadoRepository;
	
	
	private static final Logger log = LoggerFactory.getLogger( AssociadoController.class );
	
	
	public AssociadoController() {
		
	}

	

	@GetMapping(value = "/teste")
	public void teste() {
	
		
		System.out.println("\n\n\n Chegou no metodo ");
		Associado associado = new Associado();
		
		
		associado = associadoRepository.findById(1);
		
		String resultado = associado.toString();
		System.out.println(resultado);
	}	
	
	
}