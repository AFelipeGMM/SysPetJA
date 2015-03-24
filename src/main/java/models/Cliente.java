/**
 * @author André Felipe
 * */

package models;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa {

	private List<OwnedPet> animaisDeEstimacao;
	
	/**
	 * Método construtor da classe Cliente
	 * @param null
	 * */
	public Cliente() {
		
	}
	
	/**
	 * Método addAnimalDeEstimacao, adiciona um animal de estiamação ao array list
	 * @param OwnedPet
	 * @return null 
	 * */
	public void addAnimalDeEstimacao(OwnedPet pet) {
		this.animaisDeEstimacao.add(pet);
	}
	
	/**
	 * Método setAnimaisDeEstimacao, encapsula o acesso à variável animaisDeEstimacao
	 * @param ArrayList
	 * @return null
	 * */
	public void setAnimaisDeEstimacao(ArrayList<OwnedPet> animais) {
		this.animaisDeEstimacao = animais;
	}
	/**
	 * Método getAnimaisDeEstimacao, encapsula o acesso à variável animaisDeEstimacao
	 * @param null
	 * @return List
	 * */
	public List<OwnedPet> getAnimaisDeEstimacao() {
		return this.animaisDeEstimacao;
	}
}
