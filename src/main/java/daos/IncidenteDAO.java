package daos;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entidades.Incidente;
import util.JPAUtil;

public class IncidenteDAO {

	public void salvar(Incidente incidente) {
		incidente.setData(new Date());
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.persist(incidente);
		em.getTransaction().commit();
		em.close();
	}

	public List<Incidente> listarTodos() {
		EntityManager em = JPAUtil.criarEntityManager();
		String jpql = "SELECT i FROM Incidente i";
		TypedQuery<Incidente> query = em.createQuery(jpql, Incidente.class);
		List<Incidente> incidentes = query.getResultList();
		em.close();
		return incidentes;
	}
	
    public Incidente buscarPorId(Integer id) {
        EntityManager em = JPAUtil.criarEntityManager();
        Incidente incidente = em.find(Incidente.class, id);
        em.close();
        return incidente;
    }
    
    public void excluir(Incidente incidente) {
        EntityManager entityManager = JPAUtil.criarEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.merge(incidente));
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        } finally {
            entityManager.close();
        }
    }
  
    public void editar(Incidente incidente) {
        EntityManager entityManager = JPAUtil.criarEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(incidente);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        } finally {
            entityManager.close();
        }
    }

}