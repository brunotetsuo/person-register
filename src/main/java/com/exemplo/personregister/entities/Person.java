package com.exemplo.personregister.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity  // Indica que essa classe é uma entidade.
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id  // É a chave primária da tabela.
	@NotEmpty  // Não pode ser nulo ou vazio.
	private String name;
	
	@NotEmpty  // Não pode ser nulo ou vazio.
	@Email  // Valida se é um endereço de e-mail válido.
	@Column(unique = true)  // Não deixa duplicar valores iguais na coluna.
	private String email;
	
	@CPF  // Valida se é um número de CPF válido.
	@Column(unique = true)  // Não deixa duplicar valores iguais na coluna.
	private String cpf;
	
	@NotNull  // Valida se o valor da propriedade anotada não é nulo.
	@JsonFormat(pattern="dd-MM-yyyy")  // Especificar o formato em que o campo deve ser serializado.
	private LocalDate birthDate;
	
	public Person () {
	}
	
	public Person (String name, String email, String cpf, LocalDate birthDate) {
		this.name = name;
		this.email = email;
		this.cpf = cpf;
		this.birthDate = birthDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
}