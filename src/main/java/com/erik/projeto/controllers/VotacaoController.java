package com.erik.projeto.controllers;
import java.security.NoSuchAlgorithmException;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erik.projeto.dtos.VotacaoDto;
import com.erik.projeto.entities.Votacao;
import com.erik.projeto.response.ResponsePadronizado;
import com.erik.projeto.services.VotacaoService;
import com.erik.projeto.util.ConvertorDeObjetos;
import com.erik.projeto.util.ValidadorDeParametrosDeEntrada;

@RestController
@RequestMapping(value="/api/votacao", produces="application/json")
public class VotacaoController {

	@Autowired 
	private VotacaoService votacaoService;


	private static final Logger log = LoggerFactory.getLogger( VotacaoController.class );


	public VotacaoController() {

	}

	
	@PostMapping(value = "/cadastrar")
	public ResponseEntity< ResponsePadronizado<Votacao> > cadastrar( @Valid @RequestBody VotacaoDto votacaoDto,
			                                                                             BindingResult resultadoDaValidacao ) throws NoSuchAlgorithmException {

		log.info("Cadastrando uma votação");


		ResponsePadronizado<Votacao> responsePadronizado = new ResponsePadronizado<Votacao>();


		//------
		
		boolean resultadoDaValidacaoContemErros = ValidadorDeParametrosDeEntrada.verificarResultadoDaValidacaoDoBindingResult( resultadoDaValidacao, responsePadronizado );
		if( resultadoDaValidacaoContemErros ){
		
		return ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON_UTF8).body( responsePadronizado );
		
		}

		//------

		Votacao votacao = ConvertorDeObjetos.converterVotacaoDtoParaVotacao( votacaoDto );
		
		Votacao votacaoARetornar = votacaoService.cadastrar( votacao );
		
		//------		


		responsePadronizado.setConteudoDoResponse( votacaoARetornar );

		return ResponseEntity.ok().body(responsePadronizado);

	}

	
	@GetMapping(value = "/abrirsessao/{id}") 
	public ResponseEntity< ResponsePadronizado<Votacao> > abrirSessao( @PathVariable("id") long idDaVotacao  ) throws NoSuchAlgorithmException {

		log.info("Abrindo uma sessão de votação em uma pauta");


		ResponsePadronizado<Votacao> responsePadronizado = new ResponsePadronizado<Votacao>();


		//------
		
		Votacao votacao = votacaoService.buscarVotacaoPorId( idDaVotacao );
		
		//------		

		boolean resultadoDaValidacaoContemErros = ValidadorDeParametrosDeEntrada.verificarIdDaVotacao( idDaVotacao, responsePadronizado );
		if( resultadoDaValidacaoContemErros ){

		return ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON_UTF8).body( responsePadronizado );
		
		}

		//------
		
		
		responsePadronizado.setConteudoDoResponse( null );

		return ResponseEntity.ok().body(responsePadronizado);

	}


}