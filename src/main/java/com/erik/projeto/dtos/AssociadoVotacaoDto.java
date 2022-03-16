package com.erik.projeto.dtos;
import javax.validation.constraints.NotNull;

import com.erik.projeto.entities.Associado;

public class AssociadoVotacaoDto {

	
	public AssociadoVotacaoDto() {
	}

	@NotNull(message = "O pauta nome não pode ser vazio/nulo.")	
	private Associado associado;


	//-------------------------Getters and Setters----------------------//	


}