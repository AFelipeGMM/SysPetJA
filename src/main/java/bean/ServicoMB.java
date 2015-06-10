package bean;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import dao.ServicoService;
import dao.exceptions.NonexistentEntityException;
import dao.util.JPAUtil;
import dao.util.Validation;
import models.Servico;


@ManagedBean
@RequestScoped

public class ServicoMB {
	private Servico servico = new Servico();
	public final ServicoService dao = new ServicoService(JPAUtil.EMF);
	private String pesquisa;
	private List<Servico> servicos;
	private String mensagem = "";
	
	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public void salvar(){
		Validation validacao = new Validation();
		try {
			dao.createServico(servico);
			this.setMensagem(this.servico.getTipo() + " cadastrado(a) com sucesso! ");
            validacao.mensagemConfirmarCadastro(mensagem);
            servico = new Servico();
		} catch (Exception ex) {
			// TODO: handle exception
		}
	}
	
	public void excluir(long id){
        try {
            dao.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ServicoMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
	
	public void carregar(Servico servico){
        this.setServico(servico);
    }
  
    public void limpar(){
        this.setServico(new Servico());
    }
    
    public List<Servico> getServicos(){
        if(pesquisa == null){
            servicos = dao.findServicoEntities();
        } else if(pesquisa.isEmpty()){
            servicos = dao.findServicoEntities();
        } else {
            pesquisarPorNome();
        }
        return servicos;
    }
    
   
    public void pesquisarPorNome(){
        servicos = dao.pesquisarPorNome(pesquisa);
    }
    
   
    public void getTodos(){
        pesquisa = "";
        this.getServicos();
    }
    
     public void pesquisar() {
        servicos = dao.findServicoEntities();
    }

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}