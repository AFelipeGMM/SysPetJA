/**
 * @author Andr� Felipe
 * */

package models;

public class Funcionario extends Pessoa {

	private String cargo;
	private double salario;
	
	/**
	 * M�todo construtor da classe Funcionario
	 * @param null
	 * */
	public Funcionario() {
		
	}
	
	/**
	 * M�todo setCargo, encapsula o acesso � vari�vel cargo
	 * @param String
	 * @return null
	 * */
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	/**
	 * M�todo getCargo, encapsula o acesso � vari�vel cargo
	 * @param null
	 * @return String
	 * */
	public String getCargo() {
		return this.cargo;
	}
	/**
	 * M�todo setSalario, encapsula o acesso � vari�vel salario
	 * @param double
	 * @return null
	 * */
	public void setSalario(double salario) {
		this.salario = salario;
	}
	/**
	 * M�todo getSalario, encapsula o acesso � vari�vel salario
	 * @param null
	 * @return double
	 * */
	public double getSalario() {
		return this.salario;
	}
}
