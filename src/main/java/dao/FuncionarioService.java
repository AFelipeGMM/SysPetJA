package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import models.Funcionario;

public class FuncionarioService {

	private EntityManagerFactory emf = null;
	
	public FuncionarioService(EntityManagerFactory emf) {
		this.setEMF(emf);
	}
	
	public void createFuncionario(Funcionario funcionario) {
		EntityManager em = null;
		
		try {
			em = createEntityManager();
			em.getTransaction().begin();
			em.persist(funcionario);
			em.flush();
			em.refresh(funcionario);
			em.getTransaction().commit();
		} catch(Exception e) {
			//TODO tratar a exception com mais cautela
			e.printStackTrace();
		}
		
	}
	
	public void updateFuncionario() {
		//TODO
	}
	
	public void deleteFuncionario() {
		//TODO
	}
	
	public EntityManager createEntityManager() {
		return this.getEMF().createEntityManager();
	}
	
	public void setEMF(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	public EntityManagerFactory getEMF() {
		return emf;
	}
	
}
