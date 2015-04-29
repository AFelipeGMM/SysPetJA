/**
 * @author Andr
 * */

package models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Pessoa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private long cpf;
	private Endereco endereco;
	
	/**
	 * Metodo construtor da classe Pessoa
	 * @param null
	 * */
	public Pessoa() {		
	}
	
	/**
	 * Metodo setNome, encapsula o acesso a variavel "nome"
	 * @param String
	 * @return null
	 * */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * Metodo getNome, encapsula o acesso a variavel "nome"
	 * @param null
	 * @return String
	 * */
	public String getNome() {
		return this.nome;
	}
	/**
	 * Metodo setCPF, encapsula o acesso a variavel cpf
	 * @param long
	 * @return null
	 * */
	public void setCPF(long cpf) {
		this.cpf = cpf;
	}
	/**
	 * Metodo getCPF, encapsula o acesso a variavel cpf
	 * @param null
	 * @return long
	 * */
	public long getCPF() {
		return this.cpf;
	}
	/**
	 * Metodo setEndereco, encapsula o acesso a variavel endereco
	 * @param Endereco
	 * @return null
	 * */
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	/**
	 * Metodo getEndereco, encapsula o acesso a variavel endereco
	 * @param null
	 * @return Endereco
	 * */
	public Endereco getEndereco() {
		return this.endereco;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
}
