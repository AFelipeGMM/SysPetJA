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
	
	public void destroy(long id) throws NonexistentEntityException {
        EntityManager em = null;
        
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            Funcionario funcionario;
            try {
                funcionario = em.getReference(Funcionario.class, id);
                funcionario.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("O funcionario com id  " + id + " nao existe.", enfe);
            }
            em.remove(funcionario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
	
	/**
	 * Utilizado para o retorno da pagina de pesquisa 
	 * @return a recuperação da pagina de pesquisa
	 */
	public List<Funcionario> findFuncionarioEntities() {
        return findFuncionarioEntities(true, -1, -1);
     }
	
	/**
	 * Utilizado para encontrar o numero de funcionario maximo e minimo eu acho
	 * @param maxResults
	 * @param firstResult
	 * @return
	 */

    public List<Funcionario> findFuncionarioEntities(int maxResults, int firstResult) {
        return findFuncionarioEntities(false, maxResults, firstResult);
    }
    
    /**
     * lista os clientes para a tabela na pagina 
     * @param all
     * @param maxResults
     * @param firstResult
     * @return
     */

    private List<Funcionario> findFuncionarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = emf.createEntityManager();
        try {
            CriteriaQuery<Object> cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Funcionario.class));
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
     * pesquisar os funcionarios pelo nome
     * @param nome
     * @return
     */
    
    public List<Funcionario> pesquisarPorNome(String nome) {
        EntityManager em = emf.createEntityManager();

        TypedQuery<Funcionario> q;
        q = em.createQuery("select p from Funcionario p where p.nome like :nome",
                Funcionario.class);
        q.setParameter("nome", "%" + nome + "%");

        return q.getResultList();
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