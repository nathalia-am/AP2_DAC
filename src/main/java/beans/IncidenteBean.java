package beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import daos.IncidenteDAO;
import entidades.Incidente;
import entidades.Usuario;

@ManagedBean
@RequestScoped
public class IncidenteBean {

	private IncidenteDAO incidenteDAO;
	private List<Incidente> incidentes;
	private LoginBean usuarioBean = new LoginBean();

	@PostConstruct
	public void init() {
		incidenteDAO = new IncidenteDAO();
		incidentes = incidenteDAO.listarTodos();
	}

	
	public List<Incidente> getIncidentes() {
		if (incidentes == null) {
			incidenteDAO = new IncidenteDAO();
			incidentes = incidenteDAO.listarTodos();
		}
		return incidentes;
	}
	
    public String visualizarIncidente(Integer id) {
        Incidente incidente = incidenteDAO.buscarPorId(id);
        // Implemente o redirecionamento para a página de visualização detalhada do incidente
        return null;
    }

    public String editarIncidente(Integer id) {
        Incidente incidente = incidenteDAO.buscarPorId(id);
        // Implemente o redirecionamento para a página de edição do incidente
        return null;
    }

    public boolean isUsuarioLogado(Usuario usuario) {
        Usuario usuarioLogado = usuarioBean.getUsuarioLogado();
        return usuarioLogado != null && usuarioLogado.getUserId().equals(usuario.getUserId());
    }
}