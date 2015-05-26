package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

import dao.exceptions.NonexistentEntityException;
import models.Animal;

public class AnimalService {

	private EntityManagerFactory emf = null;
	
	/**
	 * Metodo construtor da classe AnimalService
	 * @param EntityManagerFactory
	 * */
	public AnimalService(EntityManagerFactory emf) {
		this.setEMF(emf);
	}
	
	/**
	 * Metodo createAnimal, persiste um animal no DB
	 * @param Animal
	 * @return null
	 * */
	public void createAnimal(Animal animal) {
		EntityManager em = null;
		
		try {
			em = createEntityManager();
			em.getTransaction().begin();
			em.persist(animal);
			em.flush();
			em.refresh(animal);
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
            Animal animal;
            try {
                animal = em.getReference(Animal.class, id);
                animal.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The animal com id " + id + " nao existe.", enfe);
            }
            em.remove(animal);
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
	 * Utilizado para o retorno da pagina de pesquisa em manterAnimal
	 * @return a recuperação da pagina de pesquisa
	 */
	public List<Animal> findAnimalEntities() {
        return findAnimalEntities(true, -1, -1);
     }
	
	/**
	 * Utilizado para encontrar o numero de animal maximo e minimo eu acho
	 * @param maxResults
	 * @param firstResult
	 * @return
	 */

    public List<Animal> findAnimalEntities(int maxResults, int firstResult) {
        return findAnimalEntities(false, maxResults, firstResult);
    }
    
    /**
     * lista os animals para a tabela na pagina manterAnimal
     * @param all
     * @param maxResults
     * @param firstResult
     * @return
     */

    private List<Animal> findAnimalEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = emf.createEntityManager();
        try {
            CriteriaQuery<Object> cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Animal.class));
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
     * pesquisar os animais pelo nome
     * @param nome
     * @return
     */
    
    public List<Animal> pesquisarPorNome(String nome) {
        EntityManager em = emf.createEntityManager();

        TypedQuery<Animal> q;
        q = em.createQuery("select p from Animal p where p.nome like :nome",
                Animal.class);
        q.setParameter("nome", "%" + nome + "%");

        return q.getResultList();
    }
}