package com.erik.projeto.services.impl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.erik.projeto.entities.Votacao;
import com.erik.projeto.repositories.VotacaoRepository;
import com.erik.projeto.services.VotacaoService;

@Service
public class VotacaoServiceImpl implements VotacaoService {
	
	private static final Logger log = LoggerFactory.getLogger(VotacaoServiceImpl.class);

	
	@Autowired
	private VotacaoRepository votacaoRepository;

	
	@Override
	public Votacao cadastrar( Votacao votacao ) {
	
		log.info("Cadastrando uma votacao");

		Votacao votacaoARetornar = votacaoRepository.save( votacao );
		
		return votacaoARetornar;
	}

	
	@Override
	public Votacao buscarVotacaoPorId( long idDaVotacao ) {
	
		log.info("Cadastrando uma votacao");

		Votacao votacaoARetornar = votacaoRepository.save( votacao );
		
		return votacaoARetornar;
	}	
}