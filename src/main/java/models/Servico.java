/**
 * @author André Felipe
 * */

package models;

public class Servico {
	
	private String tipo;
	private Animal animal;
	private double valor;
	
	/**
	 * Método construtor da classe servico
	 * @param null
	 * */
	public Servico() {
		
	}
	
	/**
	 * Método setTipo, encapsula o acesso à variável tipo
	 * @param String
	 * @return null
	 * */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	/**
	 * Método getTipo, encapsula o acesso à variável tipo
	 * @param null
	 * @return String
	 * */
	public String getTipo() {
		return this.tipo;
	}
	/**
	 * Método setAnimal, encapsula o acesso à variável animal
	 * @param Animal
	 * @return null
	 * */
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	/**
	 * Método getAnimal, encapsula o acesso à variável animal
	 * @param null
	 * @return Animal
	 * */
	public Animal getAnimal() {
		return this.animal;
	}
	/**
	 * Método setValor, encapsula o acesso à variável valor
	 * @param double
	 * @return null
	 * */
	public void setValor(double valor) {
		this.valor = valor;
	}
	/**
	 * Método getValor, encapsula o acesso à variável valor
	 * @param null
	 * @return double
	 * */
	public double getValor() {
		return this.valor;
	}
}
