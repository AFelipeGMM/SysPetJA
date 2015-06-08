/**
 * @author
 * */

package models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class OrdemServicos  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String status;
	private double valorServicoUsado;
	private double valorServicoNaoUsado;
	
	public OrdemServicos() {
		
	}

	public double getValorServicoNaoUsado() {
		return valorServicoNaoUsado;
	}

	public void setValorServicoNaoUsado(double valorServicoNaoUsado) {
		this.valorServicoNaoUsado = valorServicoNaoUsado;
	}

	public double getValorServicoUsado() {
		return valorServicoUsado;
	}

	public void setValorServicoUsado(double valorServicoUsado) {
		this.valorServicoUsado = valorServicoUsado;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
