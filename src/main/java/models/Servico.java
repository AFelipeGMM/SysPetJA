/**
 * @author
 * */

package models;

public class Servico {
	
	private String tipo;
	private Animal animal;
	private double valor;
	
	/**
	 * */
	public Servico() {
		
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getTipo() {
		return this.tipo;
	}
	
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	
	public Animal getAnimal() {
		return this.animal;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public double getValor() {
		return this.valor;
	}
}
