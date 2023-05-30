package daos;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entidades.Usuario;
import util.JPAUtil;

public class CadastroUsuarioDAO {
	
	public void salvar(Usuario usuario) {
		usuario.setDataCriacao(new Date());
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
		em.close();
    }
	
	public List<Usuario> listarTodos() {
		EntityManager em = JPAUtil.criarEntityManager();
		String jpql = "SELECT i FROM Usuario i";
		TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
		List<Usuario> usuarios = query.getResultList();
		em.close();
		return usuarios;
	}

}
