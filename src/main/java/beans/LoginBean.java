package beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import daos.CadastroUsuarioDAO;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import entidades.Usuario;
import util.JPAUtil;

@ManagedBean
@RequestScoped
public class LoginBean {

	private String email;
	private String senha;
	private Usuario usuarioLogado;
	private List<Usuario> usuarios;
	private CadastroUsuarioDAO cadastroUsuarioDAO;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String login() {
		EntityManager em = JPAUtil.criarEntityManager();
		Query query = em.createQuery("SELECT u FROM Usuario u WHERE u.email = :email AND u.senha = :senha");
		query.setParameter("email", email);
		query.setParameter("senha", senha);

		try {
			Usuario usuario = (Usuario) query.getSingleResult();

			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
			try {
				externalContext.redirect(request.getContextPath() + "/listagem_incidente.xhtml");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (NoResultException e) {
		} finally {
			em.close();
		}

		return null;
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	
	public List<Usuario> getUsuarios() {
		if (usuarios == null) {
			cadastroUsuarioDAO = new CadastroUsuarioDAO();
			usuarios = cadastroUsuarioDAO.listarTodos();
		}
		return usuarios;
	}
}