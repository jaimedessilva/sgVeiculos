package com.sgveiculos.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**Project: sgveiculos
 * File: Veiculo.java
 * @author jaime
 * Em 15-05-2020 **/

@Entity
@Table (name="t_veiculo")
public class Veiculo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private String fabricante;
	private String modelo;
	private int anoMod;
	private int anoFab;
	private double valor;
	private String placa;
	@ManyToOne (optional = true)
	@JoinColumn(name="id_prop") //id do Proprietario
	private Proprietario prop;
	
	/* Construct */
	public Veiculo() {}
	/*
	 * Construct
	 */
	public Veiculo(String fabricante, String modelo, int anoMod, int anoFab, double valor, String placa, Proprietario p) {
		
		this.fabricante = fabricante;
		this.modelo = modelo;
		this.anoMod = anoMod;
		this.anoFab = anoFab;
		this.valor = valor;
		this.placa = placa;
		this.prop = p;
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
	public String getFabricante() {
		return fabricante;
	}
	/* Setter */
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	/* Getter */
	public String getModelo() {
		return modelo;
	}
	/* Setter */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	/* Getter */
	public int getAnoMod() {
		return anoMod;
	}
	/* Setter */
	public void setAnoMod(int anoMod) {
		this.anoMod = anoMod;
	}
	/* Getter */
	public int getAnoFab() {
		return anoFab;
	}
	/* Setter */
	public void setAnoFab(int anoFab) {
		this.anoFab = anoFab;
	}
	/* Getter */
	public double getValor() {
		return valor;
	}
	/* Setter */
	public void setValor(double valor) {
		this.valor = valor;
	}
	/* Getter */
	public String getPlaca() {
		return placa;
	}
	/* Setter */
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	/* Getter */
	public Proprietario getProp() {
		return prop;
	}
	/* Setter */
	public void setProp(Proprietario prop) {
		this.prop = prop;
	}
	@Override
	public String toString() {
		return "Veiculo id:" + id + "\n fabricante:" + fabricante + "\n modelo:" + modelo + "\n ano:" + anoMod
				+ "/" + anoFab + "\n valor:" + valor + "\n placa:" + placa + "\n" +  prop;
	}
}
