/**
 * @author Andr� Felipe
 * */

package models;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa {

	private List<OwnedPet> animaisDeEstimacao;
	
	/**
	 * M�todo construtor da classe Cliente
	 * @param null
	 * */
	public Cliente() {
		
	}
	
	/**
	 * M�todo addAnimalDeEstimacao, adiciona um animal de estiama��o ao array list
	 * @param OwnedPet
	 * @return null 
	 * */
	public void addAnimalDeEstimacao(OwnedPet pet) {
		this.animaisDeEstimacao.add(pet);
	}
	
	/**
	 * M�todo setAnimaisDeEstimacao, encapsula o acesso � vari�vel animaisDeEstimacao
	 * @param ArrayList
	 * @return null
	 * */
	public void setAnimaisDeEstimacao(ArrayList<OwnedPet> animais) {
		this.animaisDeEstimacao = animais;
	}
	/**
	 * M�todo getAnimaisDeEstimacao, encapsula o acesso � vari�vel animaisDeEstimacao
	 * @param null
	 * @return List
	 * */
	public List<OwnedPet> getAnimaisDeEstimacao() {
		return this.animaisDeEstimacao;
	}
}
