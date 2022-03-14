package com.erik.projeto.util;
import java.util.Date;

import org.springframework.stereotype.Component;
import com.erik.projeto.dtos.CadastroPautaDto;
import com.erik.projeto.entities.Pauta;

@Component
public class ConvertorDeObjetos {

	
	/**
	* Converte um objeto do tipo "CadastroPautaDto" para um objeto do tipo "Pauta".
	* @param  CadastroPautaDto
	* @return Pauta
	*/
	public static  Pauta converterCadastroPautaDtoParaPauta( CadastroPautaDto cadastroPautaDto){
		
		Pauta pauta = new Pauta();
		
		pauta.setNome( cadastroPautaDto.getNome() );
		pauta.setDescricao( cadastroPautaDto.getDescricao() );
		pauta.setDatahoracriacao( new Date() );
		
		return pauta;
	}

}
