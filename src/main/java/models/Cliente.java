

package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class Cliente extends Pessoa implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private List<Animal> animaisDeEstimacao;
	
	public Cliente() {
		
	}
	
	public void addAnimalDeEstimacao(Animal pet) {
		this.animaisDeEstimacao.add(pet);
	}
	
		public void setAnimaisDeEstimacao(ArrayList<Animal> animais) {
		this.animaisDeEstimacao = animais;
	}
	
	public List<Animal> getAnimaisDeEstimacao() {
		return this.animaisDeEstimacao;
	}
	
	
}
