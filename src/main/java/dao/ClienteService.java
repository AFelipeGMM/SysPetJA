package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

import dao.exceptions.NonexistentEntityException;
import models.Cliente;

public class ClienteService {

	private EntityManagerFactory emf = null;
	
	/**
	 * Metodo construtor da classe ClienteService
	 * @param EntityManagerFactory
	 * */
	public ClienteService(EntityManagerFactory emf) {
		this.setEMF(emf);
	}
	
	/**
	 * Metodo createCliente, persiste um cliente no DB
	 * @param Cliente
	 * @return null
	 * */
	public void createCliente(Cliente cliente) {
		EntityManager em = null;
		
		try {
			em = createEntityManager();
			em.getTransaction().begin();
			em.persist(cliente);
			em.flush();
			em.refresh(cliente);
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
            Cliente cliente;
            try {
                cliente = em.getReference(Cliente.class, id);
                cliente.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cliente com id " + id + " nao existe.", enfe);
            }
            em.remove(cliente);
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
	 * Utilizado para o retorno da pagina de pesquisa em manterCliente
	 * @return a recuperação da pagina de pesquisa
	 */
	public List<Cliente> findClienteEntities() {
        return findClienteEntities(true, -1, -1);
     }
	
	/**
	 * Utilizado para encontrar o numero de cliente maximo e minimo eu acho
	 * @param maxResults
	 * @param firstResult
	 * @return
	 */

    public List<Cliente> findClienteEntities(int maxResults, int firstResult) {
        return findClienteEntities(false, maxResults, firstResult);
    }
    
    /**
     * lista os clientes para a tabela na pagina manterCliente
     * @param all
     * @param maxResults
     * @param firstResult
     * @return
     */

    private List<Cliente> findClienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = emf.createEntityManager();
        try {
            CriteriaQuery<Object> cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cliente.class));
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
     * pesquisar os clientes pelo nome
     * @param nome
     * @return
     */
    
    public List<Cliente> pesquisarPorNome(String nome) {
        EntityManager em = emf.createEntityManager();

        TypedQuery<Cliente> q;
        q = em.createQuery("select p from Cliente p where p.nome like :nome",
                Cliente.class);
        q.setParameter("nome", "%" + nome + "%");

        return q.getResultList();
    }
}