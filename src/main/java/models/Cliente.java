

package models;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa {

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
