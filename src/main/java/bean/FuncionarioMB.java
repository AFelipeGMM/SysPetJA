package bean;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import dao.exceptions.NonexistentEntityException;
import dao.util.JPAUtil;
import dao.EnderecoService;
import dao.FuncionarioService;
import models.Funcionario;
import models.Endereco;

@ManagedBean
@RequestScoped
public class FuncionarioMB {
	
	private Endereco endereco = new Endereco();
	private Funcionario funcionario = new Funcionario();
	public final EnderecoService daoEnd = new EnderecoService(JPAUtil.EMF);
	public final FuncionarioService dao = new FuncionarioService(JPAUtil.EMF);
	private String funcionarioPesquisado;
	private List<Funcionario> funcionarios;
	
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
			dao.create(funcionario);
		} catch(Exception e) {
			//TODO
		}
	}
	
	public void excluir(long id, long idEnd){
        try {
            dao.destroy(id);
            daoEnd.destroy(idEnd);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(FuncionarioMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
	
	public void carregar(Funcionario funcionario){
        this.setFuncionario(funcionario);
    }
  
    public void limpar(){
        this.setFuncionario(new Funcionario());
    }
    
    public int pesquisar() {
        funcionarios = dao.findFuncionarioEntities();
        return funcionarios.size();
    }

    public void pesquisarFuncionarios() {
        funcionarios = new ArrayList<Funcionario>();
        for (Funcionario a : dao.findFuncionarioEntities()) {
            if ((a.getEmail().toLowerCase().contains(funcionarioPesquisado) || (a.getNome().toLowerCase().contains(funcionarioPesquisado)))) {
                funcionarios.add(a);

            }
        }
        setFuncionarioPesquisado("");
       
    }
    
    public void setFuncionarioPesquisado(String funcionarioPesquisado){
    	this.funcionarioPesquisado = funcionarioPesquisado;
    }
    
    public String getFuncionarioPesquisado(){
    	return funcionarioPesquisado;
    }
	
}