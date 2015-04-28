package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import dao.util.JPAUtil;
import dao.EnderecoService;
import dao.FuncionarioService;
import models.Endereco;
import models.Funcionario;

@ManagedBean
@RequestScoped
public class FuncionarioMB {
	
	private Endereco endereco = new Endereco();
	private Funcionario funcionario = new Funcionario();
	public final EnderecoService daoEnd = new EnderecoService(JPAUtil.EMF);
	public final FuncionarioService daoFunc = new FuncionarioService(JPAUtil.EMF);
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Endereco getEndereco() {
		return this.endereco;
	}
	
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public Funcionario getFuncionario() {
		return this.funcionario;
	}
	
	public void salvar() {
		try {
			daoEnd.createEndereco(endereco);
			this.getFuncionario().setEndereco(endereco);
			daoFunc.createFuncionario(funcionario);
		} catch(Exception e) {
			//TODO
		}
	}

}
