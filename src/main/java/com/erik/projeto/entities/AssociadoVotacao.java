package com.erik.projeto.entities;
import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity                                        
@Table(name = "associado_votacao")
public class AssociadoVotacao implements Serializable {
	
	private static final long serialVersionUID = 4262991229577621987L;
	
	
	@Id                                               
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
		
	@ManyToOne
	private Associado associado;
	

	@ManyToOne
	private Votacao votacao;	
	
	
	@Column(name = "dataHoraCriacao", nullable = false)
	private Calendar dataHoraCriacao;	
	
	
	@Column(name = "tipoDeVoto", nullable = false)
	private String tipoDeVoto;	
	
	
	public AssociadoVotacao() {
	}

	//-------Getters and Setters-------//
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Associado getAssociado() {
		return associado;
	}

	public void setAssociado(Associado associado) {
		this.associado = associado;
	}


	public Votacao getVotacao() {
		return votacao;
	}

	public void setVotacao(Votacao votacao) {
		this.votacao = votacao;
	}


	public Calendar getDataHoraCriacao() {
		return dataHoraCriacao;
	}

	public void setDataHoraCriacao(Calendar dataHoraCriacao) {
		this.dataHoraCriacao = dataHoraCriacao;
	}


	public String getTipoDeVoto() {
		return tipoDeVoto;
	}

	public void setTipoDeVoto(String tipoDeVoto) {
		this.tipoDeVoto = tipoDeVoto;
	}


	//-------Metodos adicionais------//


}