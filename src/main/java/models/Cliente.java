

package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class Cliente extends Pessoa implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private List<Animal> animais;
	
	public Cliente() {
		
	}
	
	public void addAnimal(Animal pet) {
		this.animais.add(pet);
	}
	
		public void setAnimais(ArrayList<Animal> animais) {
		this.animais = animais;
	}
	
	public List<Animal> getAnimais() {
		return this.animais;
	}
	
	
}
