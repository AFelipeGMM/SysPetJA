package dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import dao.exceptions.NonexistentEntityException;
import models.Funcionario;
import models.Servico;

public class FuncionarioService implements Serializable {

    public FuncionarioService(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Funcionario funcionario) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(funcionario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Funcionario funcionario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            funcionario = em.merge(funcionario);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = funcionario.getId();
                if (findFuncionario(id) == null) {
                    throw new NonexistentEntityException("The funcionario with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Funcionario funcionario;
            try {
            	funcionario = em.getReference(Funcionario.class, id);
            	funcionario.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The funcionario with id " + id + " no longer exists.", enfe);
            }
            em.remove(funcionario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Funcionario> findFuncionarioEntities() {
        return findFuncionarioEntities(true, -1, -1);
    }

    public List<Funcionario> findFuncionarioEntities(int maxResults, int firstResult) {
        return findFuncionarioEntities(false, maxResults, firstResult);
    }

    private List<Funcionario> findFuncionarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
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
     * pesquisar os funcionario pelo nome
     * @param nome
     * @return
     */
    
    public List<Funcionario> pesquisarPorNome(String nome) {
        EntityManager em = emf.createEntityManager();

        TypedQuery<Funcionario> q;
        q = em.createQuery("select p from Servico p where p.nome like :nome",
        		Funcionario.class);
        q.setParameter("nome", "%" + nome + "%");

        return q.getResultList();
    }

    public Funcionario findFuncionario(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Funcionario.class, id);
        } finally {
            em.close();
        }
    }

    public int getFuncionarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Funcionario> rt = cq.from(Funcionario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
     public Funcionario findFuncionario(String email, String senha){
        EntityManager em = getEntityManager();
        TypedQuery<Funcionario> query;
        query = em.createQuery("select a from Funcionario a where a.email=:email" +
                               " and a.senha=:senha", Funcionario.class);
        query.setParameter("email", email);
        query.setParameter("senha", senha);
        try{
            return query.getSingleResult();
        }catch(NoResultException e){
            return null;
        }
    }
    
}