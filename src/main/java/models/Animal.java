/**
 * @author Andr� Felipe
 * */

package models;

public class Animal {

	private String raca;
	private String especie;
	private String porte;
	private String sexo;
	
	/**
	 * M�todo construtor da classe Animal
	 * @param null
	 * */
	public Animal() {
	}
	
	/**
	 * M�todo setRaca, encapsula o acesso � vari�vel raca
	 * @param String
	 * @return null
	 * */
	public void setRaca(String raca) {
		this.raca = raca;
	}
	/**
	 * M�todo getRaca, encapsula o acesso � vari�vel raca
	 * @param null
	 * @return String
	 * */
	public String getRaca() {
		return this.raca;
	}
	/**
	 * M�todo setEspecie, encapsula o acesso � vari�vel especie
	 * @param String
	 * @return null
	 * */
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	/**
	 * M�todo getEspecie, encapsula o acesso � vari�vel especie
	 * @param null
	 * @return String
	 * */
	public String getEspecie() {
		return this.especie;
	}
	/**
	 * M�todo setPorte, encapsula o acesso � vari�vel porte
	 * @param String
	 * @return null
	 * */
	public void setPorte(String porte) {
		this.porte = porte;
	}
	/**
	 * M�todo getPorte, encapsula o acesso � vari�vel porte
	 * @param null
	 * @return String
	 * */
	public String getPorte() {
		return this.porte;
	}
	/**
	 * M�todo setSexo, encapsula o acesso � vari�vel sexo
	 * @param String
	 * @return null
	 * */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	/**
	 * M�todo getSexo, encapsula o acesso � vari�vel sexo
	 * @param null
	 * @return String
	 * */
	public String getSexo() {
		return this.sexo;
	}
}
