package com.erik.projeto.util;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.stereotype.Component;

import com.erik.projeto.dtos.AssociadoDto;
import com.erik.projeto.dtos.AssociadoVotacaoDto;
import com.erik.projeto.dtos.PautaDto;
import com.erik.projeto.dtos.VotacaoDto;
import com.erik.projeto.entities.Associado;
import com.erik.projeto.entities.AssociadoVotacao;
import com.erik.projeto.entities.Pauta;
import com.erik.projeto.entities.Votacao;
import com.erik.projeto.enums.StatusVotacaoEnum;

@Component
public class ConvertorDeObjetos {


	/**
	* Converte um objeto do tipo "PautaDto" para um objeto do tipo "Pauta".
	* @param  PautaDto
	* @return Pauta
	*/
	public static  Pauta converterCadastroPautaDtoParaPauta( PautaDto pautaDto){
		
		Pauta pauta = new Pauta();
		
		pauta.setNome( pautaDto.getNome() );
		pauta.setDescricao( pautaDto.getDescricao() );
		pauta.setDatahoracriacao( new Date() );
		
		return pauta;
	}


	/**
	* Converte um objeto do tipo "AssociadoDto" para um objeto do tipo "Associado".
	* @param  AssociadoDto
	* @return Associado
	*/	
	public static Associado converterAssociadoDtoParaAssociado( AssociadoDto associadoDto ){

		Associado associado = new Associado();

		associado.setCpf( associadoDto.getCpf() );
		associado.setNome( associadoDto.getNome() );		

		return associado;
	}

	
	/**
	* Converte um objeto do tipo "VotacaoDto" para um objeto do tipo "Votacao".
	* @param  VotacaoDto
	* @return Votacao
	*/	
	public static Votacao converterVotacaoDtoParaVotacao( VotacaoDto votacaoDto) {

		Votacao votacao = new Votacao();
		
		votacao.setDataHoraCriacao( new Date() );
		votacao.setTempoDeDuracao( votacaoDto.getTempoDeDuracao() );
		votacao.setStatus( StatusVotacaoEnum.CRIADA.getStatusDaVotacao() );
		votacao.setPauta( votacaoDto.getPauta() );
		
		return votacao;
	}


	public static AssociadoVotacao converterAssociadoVotacaoDtoParaAssociadoVotacao(
			@Valid AssociadoVotacaoDto associadoVotacaoDto) {
		// TODO Auto-generated method stub
		return null;
	}

}