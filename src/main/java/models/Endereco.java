package models;

/**
 * @author Andr� Felipe
 * */

public class Endereco {
	
	private int numero;
	private String rua;
	private String bairro;
	private String cidade;
	private String uf;
	private String pais;
	private long cep;
	
	/**
	 * M�todo construtor da classe Endere�o
	 * @param null
	 * */
	public Endereco() {
	}
	
	/**
	 * M�todo setNumero, encapsula o acesso � vari�vel numero
	 * @param int
	 * @return null
	 * */
	public void setNumero(int numero) {
		this.numero = numero;
	}
	/**
	 * M�todo setNumero, encapsula o acesso � vari�vel numero
	 * @param null
	 * @return int
	 * */
	public int getNumero() {
		return this.numero;
	}
	/**
	 * M�todo setRua, encapsula o acesso � vari�vel rua
	 * @param String
	 * @return null
	 * */
	public void setRua(String rua) {
		this.rua = rua;
	}
	/**
	 * M�todo getRua, encapsula o acesso � vari�vel rua
	 * @param null
	 * @return String
	 * */
	public String getRua() {
		return this.rua;
	}
	/**
	 * M�todo setBairro, encapsula o acesso � vari�vel bairro
	 * @param String
	 * @return null
	 * */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	/**
	 * M�todo getBairro, encapsula o acesso � vari�vel bairro
	 * @param null
	 * @return String
	 * */
	public String getBairro() {
		return this.bairro;
	}
	/**
	 * M�todo setCidade, encapsula o acesso � vari�vel cidade
	 * @param String
	 * @return null
	 * */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	/**
	 * M�todo getCidade, encapsula o acesso � vari�vel cidade
	 * @param null
	 * @return String
	 * */
	public String getCidade() {
		return this.cidade;
	}
	/**
	 * M�todo setUF, encapsula o acesso � vari�vel uf
	 * @param String
	 * @return null 
	 * */
	public void setUF(String uf) {
		this.uf = uf;
	}
	/**
	 * M�todo getUF, encapsula o acesso � vari�vel uf
	 * @param null
	 * @return String
	 * */
	public String getUF() {
		return this.uf;
	}
	/**
	 * M�todo setPais, encapsula o acesso � vari�vel pais
	 * @param String
	 * @return null 
	 * */
	public void setPais(String pais) {
		this.pais = pais;
	}
	/**
	 * M�todo getPais, encapsula o acesso � vari�vel pais
	 * @param null
	 * @return String
	 * */
	public String getPais() {
		return this.pais;
	}
	/**
	 * M�todo setCEP, encapsula o acesso � vari�vel cep
	 * @param long
	 * @return null
	 * */
	public void setCEP(long cep) {
		this.cep = cep;
	}
	/**
	 * M�todo getCEP, encapsula o acesso � vari�vel cep
	 * @param null
	 * @return long
	 * */
	public long getCEP() {
		return this.cep;
	}
}
