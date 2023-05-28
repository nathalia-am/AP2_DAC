package daos;

import javax.persistence.EntityManager;

import entidades.Usuario;
import util.JPAUtil;

public class CadastroUsuarioDAO {
	
	public void salvar(Usuario usuario) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
		em.close();
    }

}
