package com.erik.projeto.entities;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity                                        
@Table(name = "associado")
public class Associado implements Serializable {
	
	private static final long serialVersionUID = 4862991749577621407L;
	
	
	@Id                                               
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "cpf", nullable = false)
	private String cpf;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	

	
	public Associado() {
	}

	//-------Getters and Setters-------//
	
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	//-------Metodos adicionais------//

	@Override
	public String toString() {
		
		return "\n Associado: \n" +
			   " > id = " +id+ "\n" +
			   " > cpf = " +cpf+ "\n" +
			   " > nome = " +nome+ "\n";
	}

}