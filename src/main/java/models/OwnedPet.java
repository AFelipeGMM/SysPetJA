/**
 * @author André Felipe
 * */

package models;

import java.util.Date;

public class OwnedPet {

	private String nome;
	private String cor;
	private double peso;
	private Date dataDeNasc;
	
	/**
	 * Método construtor da classe OwnedPet
	 * @param null
	 * */
	public OwnedPet() {
		
	}
	
	/**
	 * Método setNome, encapsula o acesso à variável nome
	 * @param String
	 * @return null
	 * */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * Método getNome, encapsula o acesso à variável nome
	 * @param null
	 * @return String
	 * */
	public String getNome() {
		return this.nome;
	}
	/**
	 * Método setCor, encapsula o acesso à variável cor
	 * @param String
	 * @return null
	 * */
	public void setCor(String cor) {
		this.cor = cor;
	}
	/**
	 * Método getCor, encapsula o acesso à variável cor
	 * @param null
	 * @return String
	 * */
	public String getCor() {
		return this.cor;
	}
	/**
	 * Método setPeso, encapsula o acesso à variável peso
	 * @param double
	 * @return null
	 * */
	public void setPeso(double peso) {
		this.peso = peso;
	}
	/**
	 * Método getPeso, encapsula o acesso à variável peso
	 * @param null
	 * @return double
	 * */
	public double getPeso() {
		return this.peso;
	}
	/**
	 * Método setDataDeNasc, encapsula o acesso à variável dataDeNasc
	 * @param Date
	 * @return null
	 * */
	public void setDataDeNasc(Date data) {
		this.dataDeNasc = data;
	}
	/**
	 * Método getDataDeNasc, encapsula o acesso à variável dataDeNasc
	 * @param null
	 * @return Date
	 * */
	public Date getDataDeNasc() {
		return this.dataDeNasc;
	}
}
