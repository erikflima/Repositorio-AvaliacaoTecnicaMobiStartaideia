package com.erik.projeto.services.impl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erik.projeto.entities.AssociadoVotacao;
import com.erik.projeto.repositories.AssociadoVotacaoRepository;
import com.erik.projeto.services.AssociadoVotacaoService;

@Service
public class AssociadoVotacaoServiceImpl implements AssociadoVotacaoService {
	
	private static final Logger log = LoggerFactory.getLogger(AssociadoVotacaoServiceImpl.class);

	
	@Autowired
	private AssociadoVotacaoRepository associadoVotacaoRepository;


	@Override
	public AssociadoVotacao cadastrar(AssociadoVotacao associadoVotacao) {
		
		log.info("Cadastrando uma AssociadoVotacao");

		AssociadoVotacao asociadoVotacaoARetornar = associadoVotacaoRepository.save( associadoVotacao );
		
		return asociadoVotacaoARetornar;
	}

	


}