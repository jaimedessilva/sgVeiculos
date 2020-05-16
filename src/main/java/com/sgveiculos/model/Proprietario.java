package com.sgveiculos.model;

/**Project: sgveiculos
 * File: Proprietario.java
 * @author jaime
 * Em 15-05-2020 **/

public class Proprietario {
	
	private Long id;
	private String nome;
	private String email;
	private String telefone;
	private String cpf;

	 /* Construct*/
	public Proprietario() {}

	/*
	 * Construct
	 */
	public Proprietario(String nome, String email, String telefone, String cpf) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.cpf = cpf;
	}

	/* Getter */
	public Long getId() {
		return id;
	}

	/* Setter */
	public void setId(Long id) {
		this.id = id;
	}

	/* Getter */
	public String getNome() {
		return nome;
	}

	/* Setter */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/* Getter */
	public String getEmail() {
		return email;
	}

	/* Setter */
	public void setEmail(String email) {
		this.email = email;
	}

	/* Getter */
	public String getTelefone() {
		return telefone;
	}

	/* Setter */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/* Getter */
	public String getCpf() {
		return cpf;
	}

	/* Setter */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return "Proprietario id:" + id + "\n nome:" + nome + "\n email:" + email + "\n telefone:" + telefone
				+ "\n cpf:" + cpf;
	}
}
