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
	 * Remove uma das entidades do banco de dados de acordo com o ID
	 * @param id
	 * @throws NonexistentEntityException
	 */
	
	public void destroy(long id) throws NonexistentEntityException {
        EntityManager em = null;
        
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            Servico servico;
            try {
                servico = em.getReference(Servico.class, id);
                servico.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("O servico " + id + " nao existe.", enfe);
            }
            em.remove(servico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
	
	/**
	 * Utilizado para o retorno da pagina de pesquisa em manterCliente
	 * @return a recuperação da pagina de pesquisa
	 */
	public List<Servico> findServicoEntities() {
        return findServicoEntities(true, -1, -1);
     }
	
	/**
	 * Utilizado para encontrar o numero de cliente maximo e minimo eu acho
	 * @param maxResults
	 * @param firstResult
	 * @return
	 */

    public List<Servico> findServicoEntities(int maxResults, int firstResult) {
        return findServicoEntities(false, maxResults, firstResult);
    }
    
    /**
     * lista os clientes para a tabela na pagina manterCliente
     * @param all
     * @param maxResults
     * @param firstResult
     * @return
     */

    private List<Servico> findServicoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = emf.createEntityManager();
        try {
            CriteriaQuery<Object> cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Servico.class));
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
    
    public List<Servico> pesquisarPorNome(String nome) {
        EntityManager em = emf.createEntityManager();

        TypedQuery<Servico> q;
        q = em.createQuery("select p from Servico p where p.nome like :nome",
        		Servico.class);
        q.setParameter("nome", "%" + nome + "%");

        return q.getResultList();
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