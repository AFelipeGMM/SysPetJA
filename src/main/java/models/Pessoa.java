package models;

/**
 * @author André Felipe
 * */

public class Pessoa {
	
	private String nome;
	private long cpf;
	private Endereco endereco;
	
	/**
	 * Método construtor da classe Pessoa
	 * @param null
	 * */
	public Pessoa() {		
	}
	
	/**
	 * Método setNome, encapsula o acesso à variável "nome"
	 * @param String
	 * @return null
	 * */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * Método getNome, encapsula o acesso à variável "nome"
	 * @param null
	 * @return String
	 * */
	public String getNome() {
		return this.nome;
	}
	/**
	 * Método setCPF, encapsula o acesso à variável cpf
	 * @param long
	 * @return null
	 * */
	public void setCPF(long cpf) {
		this.cpf = cpf;
	}
	/**
	 * Método getCPF, encapsula o acesso à variável cpf
	 * @param null
	 * @return long
	 * */
	public long getCPF() {
		return this.cpf;
	}
	/**
	 * Método setEndereco, encapsula o acesso à variável endereco
	 * @param Endereco
	 * @return null
	 * */
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	/**
	 * Método getEndereco, encapsula o acesso à variável endereco
	 * @param null
	 * @return Endereco
	 * */
	public Endereco getEndereco() {
		return this.endereco;
	}
}
