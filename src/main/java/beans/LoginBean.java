package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
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

			// Autenticação bem-sucedida, redirecionar para a página principal
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
			try {
				externalContext.redirect(request.getContextPath() + "/listagem_incidente.xhtml");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (NoResultException e) {
			// Autenticação falhou, exibir mensagem de erro
			// Você pode adicionar uma variável de mensagem para exibir no XHTML
			// ou exibir um diálogo de erro usando PrimeFaces
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
}