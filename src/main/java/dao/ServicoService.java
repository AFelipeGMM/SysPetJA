package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import models.Servico;

public class ServicoService {

	private EntityManagerFactory emf = null;
	
	/**
	 * Metodo construtor da classe EnderecoService
	 * @param EntityManagerFactory
	 * */
	public ServicoService(EntityManagerFactory emf) {
		this.setEMF(emf);
	}
	
	/**
	 * Metodo createEndereco, persiste um endereco no DB
	 * @param Endereco
	 * @return null
	 * */
	public void createServico(Servico servico) {
		EntityManager em = null;
		
		try {
			em = createEntityManager();
			em.getTransaction().begin();
			em.persist(servico);
			em.flush();
			em.refresh(servico);
			em.getTransaction().commit();
			
		}catch(Exception e) {
			//TODO tratar a exception com mais cautela
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo createEntityManager, cria um EntityManager para ser usado no service
	 * @param null
	 * @return EntityManager
	 * */
	public EntityManager createEntityManager() {
		return this.getEMF().createEntityManager();
	}
	
	/**
	 * Metodo setEMF, encapsula o acesso a variavel emf
	 * @param EntityManagerFactory
	 * @return null
	 * */
	public void setEMF(EntityManagerFactory emf) {
		this.emf = emf;
	}
	/**
	 * Metodo getEMF, encapsula o acesso a variavel emf
	 * @param null
	 * @return EntityManagerFactory
	 * */
	public EntityManagerFactory getEMF() {
		return this.emf;
	}
}
