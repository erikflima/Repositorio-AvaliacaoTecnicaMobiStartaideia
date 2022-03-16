package com.erik.projeto.services.impl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erik.projeto.entities.Associado;
import com.erik.projeto.repositories.AssociadoRepository;
import com.erik.projeto.services.AssociadoService;

@Service
public class AssociadoServiceImpl implements AssociadoService {
	
	private static final Logger log = LoggerFactory.getLogger(AssociadoServiceImpl.class);

	
	@Autowired
	private AssociadoRepository associadoRepository;

	
	@Override
	public Associado cadastrar( Associado associado ) {
	
		log.info("Cadastrando um(a) associado: ", associado.getNome() );

		Associado associadoARetornar = associadoRepository.save(associado );
		
		return associadoARetornar;
	}

}