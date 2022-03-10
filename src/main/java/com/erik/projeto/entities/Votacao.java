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
@Table(name = "votacao")
public class Votacao implements Serializable {
	
	private static final long serialVersionUID = 4862991749577621407L;
	
	
	@Id                                               
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
		
	@Column(name = "dataHoraCriacao", nullable = false)
	private Calendar dataHoraCriacao;
	
	
	@Column(name = "tempoDeDuracao", nullable = false)
	private Calendar tempoDeDuracao;	
	
	
	@Column(name = "dataHoraAbertura")
	private Calendar dataHoraAbertura;
	
	
	@Column(name = "dataHoraFechamento")
	private Calendar dataHoraFechamento;	
	
	
	@Column(name = "status")
	private String status;		
	

	@ManyToOne
	private Pauta pauta;
	
	
	public Votacao() {
	}

	
	//-------Getters and Setters-------//
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Calendar getDataHoraCriacao() {
		return dataHoraCriacao;
	}

	public void setDataHoraCriacao(Calendar dataHoraCriacao) {
		this.dataHoraCriacao = dataHoraCriacao;
	}


	public Calendar getTempoDeDuracao() {
		return tempoDeDuracao;
	}

	public void setTempoDeDuracao(Calendar tempoDeDuracao) {
		this.tempoDeDuracao = tempoDeDuracao;
	}


	public Calendar getDataHoraAbertura() {
		return dataHoraAbertura;
	}

	public void setDataHoraAbertura(Calendar dataHoraAbertura) {
		this.dataHoraAbertura = dataHoraAbertura;
	}


	public Calendar getDataHoraFechamento() {
		return dataHoraFechamento;
	}

	public void setDataHoraFechamento(Calendar dataHoraFechamento) {
		this.dataHoraFechamento = dataHoraFechamento;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public Pauta getPauta() {
		return pauta;
	}

	public void setPauta(Pauta pauta) {
		this.pauta = pauta;
	}


	//-------Metodos adicionais------//

	@Override
	public String toString() {
		
		return "Votacao "
				+ "[id=" + id + ", "
				+ "dataHoraCriacao=" 
				+ dataHoraCriacao + ", "
				+ "tempoDeDuracao=" + tempoDeDuracao
				+ ", dataHoraAbertura=" + dataHoraAbertura + ", "
				+ "dataHoraFechamento=" + dataHoraFechamento + ", "
				+ "status="	+ status + ", "
				+ "pauta=" + pauta + "]";
	}

}