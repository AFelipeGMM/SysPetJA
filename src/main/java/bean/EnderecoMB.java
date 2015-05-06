package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import dao.EnderecoService;
import dao.util.JPAUtil;
import models.Endereco;


@ManagedBean
@RequestScoped
public class EnderecoMB {
	private Endereco endereco = new Endereco();
	public final EnderecoService dao = new EnderecoService(JPAUtil.EMF);
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public void salvar(){
		try {
			dao.createEndereco(endereco);
		} catch (Exception ex) {
			// TODO: handle exception
		}
	}
	
}