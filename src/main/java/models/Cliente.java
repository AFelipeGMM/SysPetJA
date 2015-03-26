/**
 * @author Andr� Felipe
 * */

package models;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa {

	private List<Animal> animaisDeEstimacao;
	
	/**
	 * M�todo construtor da classe Cliente
	 * @param null
	 * */
	public Cliente() {
		
	}
	
	/**
	 * M�todo addAnimalDeEstimacao, adiciona um animal de estiama��o ao array list
	 * @param Animal
	 * @return null 
	 * */
	public void addAnimalDeEstimacao(Animal pet) {
		this.animaisDeEstimacao.add(pet);
	}
	
	/**
	 * M�todo setAnimaisDeEstimacao, encapsula o acesso � vari�vel animaisDeEstimacao
	 * @param ArrayList
	 * @return null
	 * */
	public void setAnimaisDeEstimacao(ArrayList<Animal> animais) {
		this.animaisDeEstimacao = animais;
	}
	/**
	 * M�todo getAnimaisDeEstimacao, encapsula o acesso � vari�vel animaisDeEstimacao
	 * @param null
	 * @return List
	 * */
	public List<Animal> getAnimaisDeEstimacao() {
		return this.animaisDeEstimacao;
	}
}
