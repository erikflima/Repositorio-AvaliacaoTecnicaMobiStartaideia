package com.erik.projeto.services;
import com.erik.projeto.entities.AssociadoVotacao;

public interface AssociadoVotacaoService {

	
	/**Anotacao para gerar JavaDoc*
	 * Cadastra um novo AssociadoVotacao na base de dados.
	 * 
	 * @param AssociadoVotacao
	 * @return AssociadoVotacao
	 */
	AssociadoVotacao cadastrar( AssociadoVotacao associadoVotacao );
	
}