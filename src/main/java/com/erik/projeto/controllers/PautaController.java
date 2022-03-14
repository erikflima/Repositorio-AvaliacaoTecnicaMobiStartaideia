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
import com.erik.projeto.dtos.CadastroPautaDto;
import com.erik.projeto.entities.Pauta;
import com.erik.projeto.response.ResponsePadronizado;
import com.erik.projeto.services.PautaService;
import com.erik.projeto.util.ConvertorDeObjetos;
import com.erik.projeto.util.ValidadorDeParametrosDeEntrada;

@RestController
@RequestMapping(value="/api/pauta", produces="application/json")
public class PautaController {

	@Autowired 
	private PautaService pautaService;
	
	
	private static final Logger log = LoggerFactory.getLogger( PautaController.class );
	
	
	public PautaController() {
		
	}

	
	@PostMapping(value = "/cadastrar")
	public ResponseEntity< ResponsePadronizado<Pauta> > cadastrar( @Valid @RequestBody CadastroPautaDto cadastroPautaDto,
			                                                                           BindingResult resultadoDaValidacao ) throws NoSuchAlgorithmException {

		log.info("Cadastrando a Pauta: ", cadastroPautaDto.getNome() );


		ResponsePadronizado<Pauta> responsePadronizado = new ResponsePadronizado<Pauta>();


		//------
		
		boolean resultadoDaValidacaoContemErros = ValidadorDeParametrosDeEntrada.verificarResultadoDaValidacaoDoBindingResult( resultadoDaValidacao, responsePadronizado );
		if( resultadoDaValidacaoContemErros ){
		
		return ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON_UTF8).body(responsePadronizado);
		
		}
		
		//------

		Pauta pauta = ConvertorDeObjetos.converterCadastroPautaDtoParaPauta(cadastroPautaDto);
		
		Pauta pautaARetornar = pautaService.cadastrar( pauta );
		
		//------		
		

		responsePadronizado.setConteudoDoResponse( pautaARetornar );
		
		return ResponseEntity.ok().body(responsePadronizado);

	}

}