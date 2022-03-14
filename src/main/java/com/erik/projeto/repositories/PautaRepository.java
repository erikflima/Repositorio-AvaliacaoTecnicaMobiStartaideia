package com.erik.projeto.repositories;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.erik.projeto.entities.Pauta;


public interface PautaRepository extends JpaRepository<Pauta, Long> {


    @Query("select count(*) from Pauta")
    public int buscaTotalDeLinhasDaTabela();
    
    
	public Pauta findById( long id );
	
	
    List<Pauta> findByNomeStartingWithIgnoreCase(String nome);


	//public Pauta save( Pauta pauta );

}