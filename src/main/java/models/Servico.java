/**
 * @author Andr� Felipe
 * */

package models;

public class Servico {
	
	private String tipo;
	private Animal animal;
	private double valor;
	
	/**
	 * M�todo construtor da classe servico
	 * @param null
	 * */
	public Servico() {
		
	}
	
	/**
	 * M�todo setTipo, encapsula o acesso � vari�vel tipo
	 * @param String
	 * @return null
	 * */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	/**
	 * M�todo getTipo, encapsula o acesso � vari�vel tipo
	 * @param null
	 * @return String
	 * */
	public String getTipo() {
		return this.tipo;
	}
	/**
	 * M�todo setAnimal, encapsula o acesso � vari�vel animal
	 * @param Animal
	 * @return null
	 * */
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	/**
	 * M�todo getAnimal, encapsula o acesso � vari�vel animal
	 * @param null
	 * @return Animal
	 * */
	public Animal getAnimal() {
		return this.animal;
	}
	/**
	 * M�todo setValor, encapsula o acesso � vari�vel valor
	 * @param double
	 * @return null
	 * */
	public void setValor(double valor) {
		this.valor = valor;
	}
	/**
	 * M�todo getValor, encapsula o acesso � vari�vel valor
	 * @param null
	 * @return double
	 * */
	public double getValor() {
		return this.valor;
	}
}
