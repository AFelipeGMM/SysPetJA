package bean;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import models.Agenda;
import dao.AgendaService;
import dao.AnimalService;
import dao.ServicoService;
import dao.exceptions.NonexistentEntityException;
import dao.util.JPAUtil;

@ManagedBean
@RequestScoped
@ViewScoped
public class AgendaMB {
	private Agenda agenda = new Agenda();
	public final AgendaService dao = new AgendaService(JPAUtil.EMF);
	public final AnimalService daoAnimal = new AnimalService(JPAUtil.EMF);
	public final ServicoService daoServico = new ServicoService(JPAUtil.EMF);
	private String pesquisa;
	private List<Agenda> agendas;
	
	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}
	

	public void salvar(){
		try {
			dao.createAgenda(agenda);
		} catch (Exception ex) {
			// TODO: handle exception
		}
	}
	
	public void excluir(long id){
        try {
            dao.destroy(id);
            
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(AgendaMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
	
	public void carregar(Agenda agenda){
        this.setAgenda(agenda);
    }
  
    public void limpar(){
        this.setAgenda(new Agenda());
    }
    
    public List<Agenda> getAgendas(){
        if(pesquisa == null){
            agendas = dao.findAgendaEntities();
        } else if(pesquisa.isEmpty()){
            agendas = dao.findAgendaEntities();
        } else {
            pesquisarPorNome();
        }
        return agendas;
    }
    
   
    public void pesquisarPorNome(){
        agendas = dao.pesquisarPorNome(pesquisa);
    }
    
   
    public void getTodos(){
        pesquisa = "";
        this.getAgendas();
    }
    
     public void pesquisar() {
        agendas = dao.findAgendaEntities();
    }
}
