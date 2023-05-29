package daos;

import java.util.Date;

import javax.persistence.EntityManager;

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

}
