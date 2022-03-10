package com.erik.projeto.repositories;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.erik.projeto.entities.Associado;


public interface AssociadoRepository extends JpaRepository<Associado, Long> {
	

    @Query("select count(*) from Associado")
    public int buscaTotalDeLinhasDaTabela();
    
    
	public Associado findById( long id );
	
	
	public Associado findByCpf( String cpf );
 
    
    //Consultar por todos os associados com nome que comecarem com a string passada no parametro, ignorando maisculas e minusculas.
    List<Associado> findByNomeStartingWithIgnoreCase(String nome);    

}