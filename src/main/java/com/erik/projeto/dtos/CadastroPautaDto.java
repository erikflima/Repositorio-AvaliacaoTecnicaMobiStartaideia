package com.erik.projeto.dtos;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

public class CadastroPautaDto {
		
	@NotEmpty(message = "O campo nome não pode ser vazio.")
	@Length(min = 3, max = 45, message = "Nome deve conter entre 3 e 45 caracteres.")
	private String nome;
	
	@NotEmpty(message = "O campo Descrição não pode ser vazio.")
	@Length(min = 5, max = 200, message = "A descrição deve conter entre 5 e 200 caracteres.")
	private String descricao;

	
	public CadastroPautaDto() {
	}

	//-------------------------Getters and Setters----------------------//	

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

}