/**
 * @author 
 * */

package models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Endereco implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private int numero;
	private String rua;
	private String bairro;
	private String cidade;
	private String uf;
	private String pais;
	private long cep;
	
	
	public Endereco() {
	}
	
	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getId() {
		return this.id;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public int getNumero() {
		return this.numero;
	}
	
	public void setRua(String rua) {
		this.rua = rua;
	}
	
	public String getRua() {
		return this.rua;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public String getBairro() {
		return this.bairro;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getCidade() {
		return this.cidade;
	}
	
	public void setUF(String uf) {
		this.uf = uf;
	}
	
	public String getUF() {
		return this.uf;
	}
	
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	public String getPais() {
		return this.pais;
	}
	
	public void setCEP(long cep) {
		this.cep = cep;
	}
	
	public long getCEP() {
		return this.cep;
	}
}
