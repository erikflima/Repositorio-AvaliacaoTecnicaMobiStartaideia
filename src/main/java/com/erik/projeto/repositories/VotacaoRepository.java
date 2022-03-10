package com.erik.projeto.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.erik.projeto.entities.Votacao;


public interface VotacaoRepository extends JpaRepository<Votacao, Long> {
	

	public Votacao findById( long id );
 
}