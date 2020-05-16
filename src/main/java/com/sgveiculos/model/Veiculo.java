package com.sgveiculos.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**Project: sgveiculos
 * File: Veiculo.java
 * @author jaime
 * Em 15-05-2020 **/

@Entity
@Table
public class Veiculo {
	
	private Long id;
	private String fabricante;
	private String modelo;
	private int anoMod;
	private int anoFab;
	private double valor;
	private String placa;
	
	/* Construct */
	public Veiculo() {}
	/*
	 * Construct
	 */
	public Veiculo(String fabricante, String modelo, int anoMod, int anoFab, double valor, String placa) {
		this.fabricante = fabricante;
		this.modelo = modelo;
		this.anoMod = anoMod;
		this.anoFab = anoFab;
		this.valor = valor;
		this.placa = placa;
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
	@Override
	public String toString() {
		return "Veiculo id:" + id + "\n fabricante:" + fabricante + "\n modelo:" + modelo + "\n anoMod:" + anoMod
				+ "\n anoFab:" + anoFab + "\n valor:" + valor + "\n placa:" + placa;
	}
}
