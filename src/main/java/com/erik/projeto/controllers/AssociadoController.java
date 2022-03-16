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
import com.erik.projeto.dtos.AssociadoDto;
import com.erik.projeto.entities.Associado;
import com.erik.projeto.response.ResponsePadronizado;
import com.erik.projeto.services.AssociadoService;
import com.erik.projeto.util.ConvertorDeObjetos;
import com.erik.projeto.util.ValidadorDeParametrosDeEntrada;

@RestController
@RequestMapping(value="/api/associado", produces="application/json")
public class AssociadoController {

	@Autowired 
	private AssociadoService associadoService;
	
	
	private static final Logger log = LoggerFactory.getLogger( AssociadoController.class );
	
	
	public AssociadoController() {
		
	}

	
	@PostMapping(value = "/cadastrar")
	public ResponseEntity< ResponsePadronizado<Associado> > cadastrar( @Valid @RequestBody AssociadoDto associadoDto,
			                                                                               BindingResult resultadoDaValidacao ) throws NoSuchAlgorithmException {

		log.info("Cadastrando o(a) associado(a): ", associadoDto.getNome() );


		ResponsePadronizado<Associado> responsePadronizado = new ResponsePadronizado<Associado>();


		//------
		
		boolean resultadoDaValidacaoContemErros = ValidadorDeParametrosDeEntrada.verificarResultadoDaValidacaoDoBindingResult( resultadoDaValidacao, responsePadronizado );
		if( resultadoDaValidacaoContemErros ){
		
		return ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON_UTF8).body( responsePadronizado );
		
		}

		//------

		Associado associado = ConvertorDeObjetos.converterAssociadoDtoParaAssociado( associadoDto );
		
		Associado associadoARetornar = associadoService.cadastrar( associado );
		
		//------		


		responsePadronizado.setConteudoDoResponse( associadoARetornar );

		return ResponseEntity.ok().body(responsePadronizado);

	}

}