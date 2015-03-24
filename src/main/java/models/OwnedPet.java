/**
 * @author Andr� Felipe
 * */

package models;

import java.util.Date;

public class OwnedPet {

	private String nome;
	private String cor;
	private double peso;
	private Date dataDeNasc;
	
	/**
	 * M�todo construtor da classe OwnedPet
	 * @param null
	 * */
	public OwnedPet() {
		
	}
	
	/**
	 * M�todo setNome, encapsula o acesso � vari�vel nome
	 * @param String
	 * @return null
	 * */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * M�todo getNome, encapsula o acesso � vari�vel nome
	 * @param null
	 * @return String
	 * */
	public String getNome() {
		return this.nome;
	}
	/**
	 * M�todo setCor, encapsula o acesso � vari�vel cor
	 * @param String
	 * @return null
	 * */
	public void setCor(String cor) {
		this.cor = cor;
	}
	/**
	 * M�todo getCor, encapsula o acesso � vari�vel cor
	 * @param null
	 * @return String
	 * */
	public String getCor() {
		return this.cor;
	}
	/**
	 * M�todo setPeso, encapsula o acesso � vari�vel peso
	 * @param double
	 * @return null
	 * */
	public void setPeso(double peso) {
		this.peso = peso;
	}
	/**
	 * M�todo getPeso, encapsula o acesso � vari�vel peso
	 * @param null
	 * @return double
	 * */
	public double getPeso() {
		return this.peso;
	}
	/**
	 * M�todo setDataDeNasc, encapsula o acesso � vari�vel dataDeNasc
	 * @param Date
	 * @return null
	 * */
	public void setDataDeNasc(Date data) {
		this.dataDeNasc = data;
	}
	/**
	 * M�todo getDataDeNasc, encapsula o acesso � vari�vel dataDeNasc
	 * @param null
	 * @return Date
	 * */
	public Date getDataDeNasc() {
		return this.dataDeNasc;
	}
}
