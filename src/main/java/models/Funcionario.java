/**
 * 
 * */

package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class Funcionario extends Pessoa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String cargo;
	private double salario;
	private List<Agenda> agendas;
	
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

	public List<Agenda> getAgendas() {
		return agendas;
	}

	public void setAgendas(List<Agenda> agendas) {
		this.agendas = agendas;
	}
	public void addAgenda(Agenda agenda){
		agendas.add(agenda);
	}
	
}