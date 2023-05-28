package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import daos.CadastroUsuarioDAO;
import entidades.Usuario;

@ManagedBean
public class CadastroBean {

	private CadastroUsuarioDAO usuarioDAO = new CadastroUsuarioDAO();
	private Usuario novoUsuario = new Usuario();
	
	public Usuario getNovoUsuario() {
		return novoUsuario;
	}

	public void setNovoUsuario(Usuario novoUsuario) {
		this.novoUsuario = novoUsuario;
	}

	public String cadastrarUsuario() {
		try {
			usuarioDAO.salvar(novoUsuario);
			novoUsuario = new Usuario();
			
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
			try {
				externalContext.redirect(request.getContextPath() + "/index.xhtml");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception error) {
			throw new RuntimeException("Não foi possível salvar o email: " + error.getMessage());
		}
		return null;
	}

}
