package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import models.Endereco;

public class EnderecoService {

	private EntityManagerFactory emf = null;
	
	/**
	 * M�todo construtor da classe EnderecoService
	 * @param EntityManagerFactory
	 * */
	public EnderecoService(EntityManagerFactory emf) {
		this.setEMF(emf);
	}
	
	/**
	 * M�todo createEndereco, persiste um endereco no DB
	 * @param Endereco
	 * @return null
	 * */
	public void createEndereco(Endereco endereco) {
		EntityManager em = null;
		
		try {
			em = createEntityManager();
			em.getTransaction().begin();
			em.persist(endereco);
			em.flush();
			em.refresh(endereco);
			em.getTransaction().commit();
			
		}catch(Exception e) {
			//TODO tratar a exception com mais cautela
			e.printStackTrace();
		}
	}
	
	/**
	 * M�todo createEntityManager, cria um EntityManager para ser usado no service
	 * @param null
	 * @return EntityManager
	 * */
	public EntityManager createEntityManager() {
		return this.getEMF().createEntityManager();
	}
	
	/**
	 * M�todo setEMF, encapsula o acesso � vari�vel emf
	 * @param EntityManagerFactory
	 * @return null
	 * */
	public void setEMF(EntityManagerFactory emf) {
		this.emf = emf;
	}
	/**
	 * M�todo getEMF, encapsula o acesso � vari�vel emf
	 * @param null
	 * @return EntityManagerFactory
	 * */
	public EntityManagerFactory getEMF() {
		return this.emf;
	}
}
