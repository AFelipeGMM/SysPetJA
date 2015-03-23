package models;

/**
 * @author Andr� Felipe
 * */

public class Pessoa {
	
	private String nome;
	private long cpf;
	private Endereco endereco;
	
	/**
	 * M�todo construtor da classe Pessoa
	 * @param null
	 * */
	public Pessoa() {		
	}
	
	/**
	 * M�todo setNome, encapsula o acesso � vari�vel "nome"
	 * @param String
	 * @return null
	 * */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * M�todo getNome, encapsula o acesso � vari�vel "nome"
	 * @param null
	 * @return String
	 * */
	public String getNome() {
		return this.nome;
	}
	/**
	 * M�todo setCPF, encapsula o acesso � vari�vel cpf
	 * @param long
	 * @return null
	 * */
	public void setCPF(long cpf) {
		this.cpf = cpf;
	}
	/**
	 * M�todo getCPF, encapsula o acesso � vari�vel cpf
	 * @param null
	 * @return long
	 * */
	public long getCPF() {
		return this.cpf;
	}
	/**
	 * M�todo setEndereco, encapsula o acesso � vari�vel endereco
	 * @param Endereco
	 * @return null
	 * */
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	/**
	 * M�todo getEndereco, encapsula o acesso � vari�vel endereco
	 * @param null
	 * @return Endereco
	 * */
	public Endereco getEndereco() {
		return this.endereco;
	}
}
