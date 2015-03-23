package models;

/**
 * @author André Felipe
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
	 * Método construtor da classe Endereço
	 * @param null
	 * */
	public Endereco() {
	}
	
	/**
	 * Método setNumero, encapsula o acesso à variável numero
	 * @param int
	 * @return null
	 * */
	public void setNumero(int numero) {
		this.numero = numero;
	}
	/**
	 * Método setNumero, encapsula o acesso à variável numero
	 * @param null
	 * @return int
	 * */
	public int getNumero() {
		return this.numero;
	}
	/**
	 * Método setRua, encapsula o acesso à variável rua
	 * @param String
	 * @return null
	 * */
	public void setRua(String rua) {
		this.rua = rua;
	}
	/**
	 * Método getRua, encapsula o acesso à variável rua
	 * @param null
	 * @return String
	 * */
	public String getRua() {
		return this.rua;
	}
	/**
	 * Método setBairro, encapsula o acesso à variável bairro
	 * @param String
	 * @return null
	 * */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	/**
	 * Método getBairro, encapsula o acesso à variável bairro
	 * @param null
	 * @return String
	 * */
	public String getBairro() {
		return this.bairro;
	}
	/**
	 * Método setCidade, encapsula o acesso à variável cidade
	 * @param String
	 * @return null
	 * */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	/**
	 * Método getCidade, encapsula o acesso à variável cidade
	 * @param null
	 * @return String
	 * */
	public String getCidade() {
		return this.cidade;
	}
	/**
	 * Método setUF, encapsula o acesso à variável uf
	 * @param String
	 * @return null 
	 * */
	public void setUF(String uf) {
		this.uf = uf;
	}
	/**
	 * Método getUF, encapsula o acesso à variável uf
	 * @param null
	 * @return String
	 * */
	public String getUF() {
		return this.uf;
	}
	/**
	 * Método setPais, encapsula o acesso à variável pais
	 * @param String
	 * @return null 
	 * */
	public void setPais(String pais) {
		this.pais = pais;
	}
	/**
	 * Método getPais, encapsula o acesso à variável pais
	 * @param null
	 * @return String
	 * */
	public String getPais() {
		return this.pais;
	}
	/**
	 * Método setCEP, encapsula o acesso à variável cep
	 * @param long
	 * @return null
	 * */
	public void setCEP(long cep) {
		this.cep = cep;
	}
	/**
	 * Método getCEP, encapsula o acesso à variável cep
	 * @param null
	 * @return long
	 * */
	public long getCEP() {
		return this.cep;
	}
}
