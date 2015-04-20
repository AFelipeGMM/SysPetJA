/**
 * 
 * */

package models;

public class Funcionario extends Pessoa {

	private String cargo;
	private double salario;
	
	public Funcionario() {
		
	}
	
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public String getCargo() {
		return this.cargo;
	}
	
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public double getSalario() {
		return this.salario;
	}
}
