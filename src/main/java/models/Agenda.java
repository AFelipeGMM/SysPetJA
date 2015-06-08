package models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Agenda implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Temporal(TemporalType.DATE)
	private Date dataAgenda;
	@Temporal(TemporalType.TIME)
	private Date horaInicio;
	@Temporal(TemporalType.TIME)
	private Date horaFim;
	
	private Animal animal;
	private Servico servico;
	private boolean Status = false;
	
	public Animal getAnimal() {
		return animal;
	}
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	public Servico getServico() {
		return servico;
	}
	public void setServico(Servico servico) {
		this.servico = servico;
	}
	public boolean isStatus() {
		return Status;
	}
	public void setStatus(boolean status) {
		Status = status;
	}
	public long getId(){
		return id;
	}
	public Date getDataAgenda() {
		return dataAgenda;
	}
	public void setDataAgenda(Date dataAgenda) {
		this.dataAgenda = dataAgenda;
	}
	public Date getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}
	public Date getHoraFim() {
		return horaFim;
	}
	public void setHoraFim(Date horaFim) {
		this.horaFim = horaFim;
	}
	

}
