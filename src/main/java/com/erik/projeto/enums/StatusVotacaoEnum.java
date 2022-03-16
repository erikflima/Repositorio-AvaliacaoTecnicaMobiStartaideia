package com.erik.projeto.enums;


public enum StatusVotacaoEnum {
	
	
	CRIADA("CRIADA"),
	ABERTA("ABERTA"),
	ENCERRADA("ENCERRADA");


	//-------------------------Constructors-------------------------------//
	
	StatusVotacaoEnum( String statusDaVotacao){
		
		this.statusDaVotacao = statusDaVotacao;
	}
	
	
	private String statusDaVotacao;

	
	//------------------------------Getters and Setters-------------------//
	
	public String getStatusDaVotacao() {
		return statusDaVotacao;
	}


}