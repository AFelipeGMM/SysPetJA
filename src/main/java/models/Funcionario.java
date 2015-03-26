/**
 * @author André Felipe
 * */

package models;

public class Funcionario extends Pessoa {

	private String cargo;
	private double salario;
	
	/**
	 * Método construtor da classe Funcionario
	 * @param null
	 * */
	public Funcionario() {
		
	}
	
	/**
	 * Método setCargo, encapsula o acesso à variável cargo
	 * @param String
	 * @return null
	 * */
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	/**
	 * Método getCargo, encapsula o acesso à variável cargo
	 * @param null
	 * @return String
	 * */
	public String getCargo() {
		return this.cargo;
	}
	/**
	 * Método setSalario, encapsula o acesso à variável salario
	 * @param double
	 * @return null
	 * */
	public void setSalario(double salario) {
		this.salario = salario;
	}
	/**
	 * Método getSalario, encapsula o acesso à variável salario
	 * @param null
	 * @return double
	 * */
	public double getSalario() {
		return this.salario;
	}
}
