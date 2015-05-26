package bean;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import dao.AnimalService;
import dao.EnderecoService;
import dao.exceptions.NonexistentEntityException;
import dao.util.JPAUtil;
import models.Animal;

@ManagedBean
@RequestScoped
public class AnimalMB {
	private Animal animal = new Animal();
	public final AnimalService dao = new AnimalService(JPAUtil.EMF);
	public final EnderecoService daoEndereco = new EnderecoService(JPAUtil.EMF);
	private String pesquisa;
	private List<Animal> animais;
	
	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	

	public void salvar(){
		try {
			dao.createAnimal(animal);
		} catch (Exception ex) {
			// TODO: handle exception
		}
	}
	
	public void excluir(long id, long idEnd){
        try {
            dao.destroy(id);
            daoEndereco.destroy(idEnd);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(AnimalMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
	
	public void carregar(Animal animal){
        this.setAnimal(animal);
    }
  
    public void limpar(){
        this.setAnimal(new Animal());
    }
    
    public List<Animal> getAnimais(){
        if(pesquisa == null){
            animais = dao.findAnimalEntities();
        } else if(pesquisa.isEmpty()){
            animais = dao.findAnimalEntities();
        } else {
            pesquisarPorNome();
        }
        return animais;
    }
    
   
    public void pesquisarPorNome(){
        animais = dao.pesquisarPorNome(pesquisa);
    }
    
   
    public void getTodos(){
        pesquisa = "";
        this.getAnimais();
    }
    
     public void pesquisar() {
        animais = dao.findAnimalEntities();
    }
	
}