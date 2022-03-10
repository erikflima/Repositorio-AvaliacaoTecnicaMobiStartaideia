package com.erik.projeto.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.erik.projeto.entities.AssociadoVotacao;


public interface AssociadoVotacaoRepository extends JpaRepository<AssociadoVotacao, Long> {
	

	public AssociadoVotacao findById( long id );
 
}