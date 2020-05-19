package com.sgveiculos.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**Project: sgveiculos
 * File: Proprietario.java
 * @author jaime
 * Em 15-05-2020 **/

@Entity
@Table(name="t_proprietario")
public class Proprietario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private String telefone;
	private String cpf;
	@OneToMany //(cascade=CascadeType.ALL,mappedBy = "prop")
	private List<Veiculo> veiculos;

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
	/* Getter */
	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	/* Setter */
	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

	@Override
	public String toString() {
		return "\n Prop id:" + id + "\n Nome:" + nome + "\n Email:" + email + "\n Telefone:" + telefone
				+ "\n cpf:" + cpf;
	}
}
