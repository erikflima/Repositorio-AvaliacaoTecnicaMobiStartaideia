package com.erik.projeto.services;
import com.erik.projeto.entities.Votacao;

public interface VotacaoService {

	/**Anotacao para gerar JavaDoc*
	 * Cadastra uma nova votação na base de dados.
	 * 
	 * @param Votacao
	 * @return Votacao
	 */
	Votacao cadastrar( Votacao votacao );
	
}