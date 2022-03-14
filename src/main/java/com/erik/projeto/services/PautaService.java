package com.erik.projeto.services;
import com.erik.projeto.entities.Pauta;

public interface PautaService {
	
	/**Anotacao para gerar JavaDoc*
	 * Cadastra uma nova pauta na base de dados.
	 * 
	 * @param Pauta
	 * @return Pauta
	 */
	Pauta cadastrar( Pauta pauta );
	
}