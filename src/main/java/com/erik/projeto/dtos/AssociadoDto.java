package com.erik.projeto.dtos;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

public class AssociadoDto {

	@NotEmpty(message = "CPF não pode ser vazio.")
	@CPF(message="CPF inválido")
	private String cpf;
	
	@NotEmpty(message = "O campo nome não pode ser vazio.")
	@Length(min = 3, max = 45, message = "Nome deve conter entre 3 e 45 caracteres.")
	private String nome;

	
	public AssociadoDto() {
	}

	//-------------------------Getters and Setters----------------------//	
	
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
	
}