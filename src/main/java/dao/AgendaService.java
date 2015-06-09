package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

import models.Agenda;
import dao.exceptions.NonexistentEntityException;

public class AgendaService {
	
private EntityManagerFactory emf = null;
	
	/**
	 * Metodo construtor da classe AgendaService
	 * @param EntityManagerFactory
	 * */
	public AgendaService(EntityManagerFactory emf) {
		this.setEMF(emf);
	}
	
	/**
	 * Metodo createAgenda, persiste um agenda no DB
	 * @param Agenda
	 * @return null
	 * */
	public void createAgenda(Agenda agenda) {
		EntityManager em = null;
		
		try {
			em = createEntityManager();
			em.getTransaction().begin();
			em.persist(agenda);
			em.flush();
			em.refresh(agenda);
			em.getTransaction().commit();
			em.close();
			
		}catch(Exception e) {
			//TODO tratar a exception com mais cautela
			e.printStackTrace();
		}
	}
	
	/**
	 * Remove uma das entidades do banco de dados de acordo com o ID
	 * @param id
	 * @throws NonexistentEntityException
	 */
	
	public void destroy(long id) throws NonexistentEntityException {
        EntityManager em = null;
        
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            Agenda agenda;
            try {
                agenda = em.getReference(Agenda.class, id);
                agenda.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The agenda com id " + id + " nao existe.", enfe);
            }
            em.remove(agenda);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
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
	
	/**
	 * Utilizado para o retorno da pagina de pesquisa em manterAgenda
	 * @return a recuperacao da pagina de pesquisa
	 */
	public List<Agenda> findAgendaEntities() {
        return findAgendaEntities(true, -1, -1);
     }
	
	/**
	 * Utilizado para encontrar o numero de agenda maximo e minimo eu acho
	 * @param maxResults
	 * @param firstResult
	 * @return
	 */

    public List<Agenda> findAgendaEntities(int maxResults, int firstResult) {
        return findAgendaEntities(false, maxResults, firstResult);
    }
    
    /**
     * lista os agendas para a tabela na pagina manterAgenda
     * @param all
     * @param maxResults
     * @param firstResult
     * @return
     */

    private List<Agenda> findAgendaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = emf.createEntityManager();
        try {
            CriteriaQuery<Object> cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Agenda.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }
    
    /**
     * pesquisar as agendas pelo nome
     * @param nome
     * @return
     */
    
    public List<Agenda> pesquisarPorNome(String nome) {
        EntityManager em = emf.createEntityManager();

        TypedQuery<Agenda> q;
        q = em.createQuery("select p from Agenda p where p.nome like :nome",
                Agenda.class);
        q.setParameter("nome", "%" + nome + "%");

        return q.getResultList();
    }

}