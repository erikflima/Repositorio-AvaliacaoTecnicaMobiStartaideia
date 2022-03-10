package com.erik.projeto.entities;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity                                        
@Table(name = "pauta")
public class Pauta implements Serializable {
	
	private static final long serialVersionUID = 4862991749577621408L;
	
	
	@Id                                               
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	

	@Column(name = "descricao", nullable = false)
	private String descricao;
	
	@Column(name = "datahoracriacao", nullable = false)
	private Date datahoracriacao;	

	
	
	public Pauta() {
	}

	//-------Getters and Setters-------//
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
	public Date getDatahoracriacao() {
		return datahoracriacao;
	}

	public void setDatahoracriacao(Date datahoracriacao) {
		this.datahoracriacao = datahoracriacao;
	}


	//-------Metodos adicionais------//

	@Override
	public String toString() {
		
		return "\n Pauta: \n" +
			   " > id = " +id+ "\n" +
			   " > nome = " +nome+ "\n" +
			   " > descricao = " +descricao+ "\n";
	}

}