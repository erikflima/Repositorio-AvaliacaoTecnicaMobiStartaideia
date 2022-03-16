package com.erik.projeto.controllers;
import java.security.NoSuchAlgorithmException;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erik.projeto.dtos.AssociadoVotacaoDto;
import com.erik.projeto.entities.AssociadoVotacao;
import com.erik.projeto.response.ResponsePadronizado;
import com.erik.projeto.services.AssociadoVotacaoService;
import com.erik.projeto.util.ConvertorDeObjetos;
import com.erik.projeto.util.ValidadorDeParametrosDeEntrada;

@RestController
@RequestMapping(value="/api/associadovotacao", produces="application/json")
public class AssociadoVotacaoController {

	@Autowired 
	private AssociadoVotacaoService associadoVotacaoService;

	
	private static final Logger log = LoggerFactory.getLogger( AssociadoVotacaoController.class );
	
	
	public AssociadoVotacaoController() {
		
	}

	
	@PostMapping(value = "/cadastrar")
	public ResponseEntity< ResponsePadronizado< AssociadoVotacao > > cadastrar( @Valid @RequestBody AssociadoVotacaoDto associadoVotacaoDto,
			                                                                                        BindingResult resultadoDaValidacao ) throws NoSuchAlgorithmException {

		log.info("Cadastrando uma AssociadoVotacao");


		ResponsePadronizado<AssociadoVotacao> responsePadronizado = new ResponsePadronizado<AssociadoVotacao>();


		//------
		
		boolean resultadoDaValidacaoContemErros = ValidadorDeParametrosDeEntrada.verificarResultadoDaValidacaoDoBindingResult( resultadoDaValidacao, responsePadronizado );
		if( resultadoDaValidacaoContemErros ){
		
		return ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON_UTF8).body( responsePadronizado );
		
		}

		//------

		AssociadoVotacao associadoVotacao = ConvertorDeObjetos.converterAssociadoVotacaoDtoParaAssociadoVotacao( associadoVotacaoDto );
		
		AssociadoVotacao associadoVotacaoARetornar = associadoVotacaoService.cadastrar( associadoVotacao );
		
		//------		


		responsePadronizado.setConteudoDoResponse( associadoVotacaoARetornar );

		return ResponseEntity.ok().body(responsePadronizado);

	}

	
	
	
	
}