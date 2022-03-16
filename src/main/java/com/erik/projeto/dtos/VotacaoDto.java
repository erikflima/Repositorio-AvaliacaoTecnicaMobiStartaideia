package com.erik.projeto.dtos;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.erik.projeto.entities.Pauta;

public class VotacaoDto {

	
	public VotacaoDto() {
	}

	@NotNull(message = "O pauta nome não pode ser vazio/nulo.")	
	private Pauta pauta;
	
	@Min(value = 60000, message = "O tempoDeDuracao deve ser no mínimo 60000 milisegundos (ou seja, 1 minuto).")
	private Long tempoDeDuracao;


	//-------------------------Getters and Setters----------------------//	
	
	public Pauta getPauta() {
		return pauta;
	}

	public void setPauta(Pauta pauta) {
		this.pauta = pauta;
	}


	public Long getTempoDeDuracao() {
		return tempoDeDuracao;
	}

	public void setTempoDeDuracao(Long tempoDeDuracao) {
		this.tempoDeDuracao = tempoDeDuracao;
	}

}