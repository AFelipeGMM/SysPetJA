/**
 * @author André Felipe
 * */

package models;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa {

	private List<Animal> animaisDeEstimacao;
	
	/**
	 * Método construtor da classe Cliente
	 * @param null
	 * */
	public Cliente() {
		
	}
	
	/**
	 * Método addAnimalDeEstimacao, adiciona um animal de estiamação ao array list
	 * @param Animal
	 * @return null 
	 * */
	public void addAnimalDeEstimacao(Animal pet) {
		this.animaisDeEstimacao.add(pet);
	}
	
	/**
	 * Método setAnimaisDeEstimacao, encapsula o acesso à variável animaisDeEstimacao
	 * @param ArrayList
	 * @return null
	 * */
	public void setAnimaisDeEstimacao(ArrayList<Animal> animais) {
		this.animaisDeEstimacao = animais;
	}
	/**
	 * Método getAnimaisDeEstimacao, encapsula o acesso à variável animaisDeEstimacao
	 * @param null
	 * @return List
	 * */
	public List<Animal> getAnimaisDeEstimacao() {
		return this.animaisDeEstimacao;
	}
}
