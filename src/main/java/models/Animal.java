/**
 * @author André Felipe
 * */

package models;

public class Animal {

	private String raca;
	private String especie;
	private String porte;
	private String sexo;
	
	/**
	 * Método construtor da classe Animal
	 * @param null
	 * */
	public Animal() {
	}
	
	/**
	 * Método setRaca, encapsula o acesso a variável raca
	 * @param String
	 * @return null
	 * */
	public void setRaca(String raca) {
		this.raca = raca;
	}
	/**
	 * Método getRaca, encapsula o acesso a variável raca
	 * @param null
	 * @return String
	 * */
	public String getRaca() {
		return this.raca;
	}
	/**
	 * Método setEspecie, encapsula o acesso a variável especie
	 * @param String
	 * @return null
	 * */
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	/**
	 * Método getEspecie, encapsula o acesso a variável especie
	 * @param null
	 * @return String
	 * */
	public String getEspecie() {
		return this.especie;
	}
	/**
	 * Método setPorte, encapsula o acesso a variável porte
	 * @param String
	 * @return null
	 * */
	public void setPorte(String porte) {
		this.porte = porte;
	}
	/**
	 * Metodo getPorte, encapsula o acesso a variavel porte
	 * @param null
	 * @return String
	 * */
	public String getPorte() {
		return this.porte;
	}
	/**
	 * Metodo setSexo, encapsula o acesso a variavel sexo
	 * @param String
	 * @return null
	 * */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	/**
	 * Metodo getSexo, encapsula o acesso a variavel sexo
	 * @param null
	 * @return String
	 * */
	public String getSexo() {
		return this.sexo;
	}
}
