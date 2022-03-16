package com.erik.projeto.util;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.erik.projeto.entities.Votacao;
import com.erik.projeto.response.ResponsePadronizado;


@Component
public class ValidadorDeParametrosDeEntrada {


	private static final Logger log = LoggerFactory.getLogger( ValidadorDeParametrosDeEntrada.class );

	
	/**
	* Realiza a validação de um objeto "BindingResult" recebido, se houver erros de validação registrados, então objeto "ResponsePadronizado<?>" é preparado para que seja possivel retorna-lo como resposta.
	* @param  BindingResult          - Objeto para informar os erros de validação ocorridos.
	* @param  ResponsePadronizado<?> - Resposta padronizada.
	* @return boolean                - 'true' caso exista erros de validação. 'false' caso não existam erros de validação.
	*/
	public static boolean verificarResultadoDaValidacaoDoBindingResult( BindingResult resultadoDaValidacao,  ResponsePadronizado<?> responsePadronizado  ){
		
		
		log.info("Executando verificarResultadoDaValidacaoDosDadosDeEntrada()'");
		
		
		//Verificando a validacao dos dados de entrada feita automaticamente pelo Hibernate.
		if ( resultadoDaValidacao.hasErrors() ) {
			
			
			log.error( "Há erros da validação no objeto dto recebido: ", resultadoDaValidacao.getAllErrors() );
			
			
			List<ObjectError> listaDeErros = resultadoDaValidacao.getAllErrors();
			
			
			for( ObjectError auxiliar : listaDeErros  ){
				
				//Pegar a mensagem de erro da posicao atual.
				String mensagemDeErroExtraida = auxiliar.getDefaultMessage();	

				//Preparar mensagem de erro os dados recebidos estejam no tipo incorreto.
				if( auxiliar.getCode().equals("typeMismatch") ){
					
					mensagemDeErroExtraida = "Os parametrôs recebidos não estão com a tipagem(texto, númerico, etc) correta. Por favor, verifique o tipo dos parametrôs.";
				}

				responsePadronizado.getErrors().add(mensagemDeErroExtraida);

			}
					
			//Foram encontrados erros de validação.
			return true;
		}
		
		//Não foram encontrados erros de validação.
		return false;
	}


}