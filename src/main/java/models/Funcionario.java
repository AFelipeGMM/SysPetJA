/**
 * 
 * */

package models;

import java.io.Serializable;
import javax.persistence.Entity;

@Entity
public class Funcionario extends Pessoa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
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
