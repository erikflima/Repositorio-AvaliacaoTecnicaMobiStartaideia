package com.erik.projeto.services.impl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erik.projeto.entities.Pauta;
import com.erik.projeto.repositories.PautaRepository;
import com.erik.projeto.services.PautaService;

@Service
public class PautaServiceImpl implements PautaService {
	
	private static final Logger log = LoggerFactory.getLogger(PautaServiceImpl.class);

	
	@Autowired
	private PautaRepository pautaRepository;

	
	@Override
	public Pauta cadastrar( Pauta pauta ) {
	
		log.info("Cadastrando uma pauta: ", pauta.getNome() );

		Pauta pautaARetornar = pautaRepository.save(pauta );
		
		return pautaARetornar;
	}

}