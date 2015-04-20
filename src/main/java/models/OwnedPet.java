/**
 * @author
 * */

package models;

import java.util.Date;

public class OwnedPet {

	private String nome;
	private String cor;
	private double peso;
	private Date dataDeNasc;
	
	public OwnedPet() {
		
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	public String getCor() {
		return this.cor;
	}
	
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public double getPeso() {
		return this.peso;
	}
	
	public void setDataDeNasc(Date data) {
		this.dataDeNasc = data;
	}

	public Date getDataDeNasc() {
		return this.dataDeNasc;
	}
}
