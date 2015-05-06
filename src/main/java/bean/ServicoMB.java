package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import dao.ServicoService;
import dao.util.JPAUtil;
import models.Servico;


@ManagedBean
@RequestScoped

public class ServicoMB {
	private Servico servico = new Servico();
	public final ServicoService dao = new ServicoService(JPAUtil.EMF);
	
	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public void salvar(){
		try {
			dao.createServico(servico);
		} catch (Exception ex) {
			// TODO: handle exception
		}
	}
}