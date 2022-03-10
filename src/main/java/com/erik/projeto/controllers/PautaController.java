package com.erik.projeto.controllers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erik.projeto.entities.Pauta;
import com.erik.projeto.repositories.PautaRepository;

@RestController
@RequestMapping(value="/api/pauta", produces="application/json")
public class PautaController {

	@Autowired 
	private PautaRepository pautaRepository;
	
	
	private static final Logger log = LoggerFactory.getLogger( PautaController.class );
	
	
	public PautaController() {
		
	}

	

	@GetMapping(value = "/teste")
	public void teste() {
	
		
		System.out.println("\n\n\n Chegou no metodo ");
		Pauta pauta = new Pauta();
		
		
		pauta = pautaRepository.findById(1);
		
		String resultado = pauta.toString();
		System.out.println(resultado);
	}	
	
	
}