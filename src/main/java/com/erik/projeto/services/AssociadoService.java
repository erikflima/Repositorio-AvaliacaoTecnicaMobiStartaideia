package com.erik.projeto.services;
import com.erik.projeto.entities.Associado;

public interface AssociadoService {
	
	
	/**Anotacao para gerar JavaDoc*
	 * Cadastra um novo associado na base de dados.
	 * 
	 * @param Associado
	 * @return Associado
	 */
	Associado cadastrar( Associado associado );

}