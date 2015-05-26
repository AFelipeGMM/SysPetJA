/**
 * @author André Felipe
 * */

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
public class Animal implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nome;
	private String cor;
	private double peso;
	@Temporal(TemporalType.DATE)
	private Date dataDeNasc;
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

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the cor
	 */
	public String getCor() {
		return cor;
	}

	/**
	 * @param cor the cor to set
	 */
	public void setCor(String cor) {
		this.cor = cor;
	}

	/**
	 * @return the peso
	 */
	public double getPeso() {
		return peso;
	}

	/**
	 * @param peso the peso to set
	 */
	public void setPeso(double peso) {
		this.peso = peso;
	}

	/**
	 * @return the dataDeNasc
	 */
	public Date getDataDeNasc() {
		return dataDeNasc;
	}

	/**
	 * @param dataDeNasc the dataDeNasc to set
	 */
	public void setDataDeNasc(Date dataDeNasc) {
		this.dataDeNasc = dataDeNasc;
	}
	
	public long getId(){
		return id;
	}
}
