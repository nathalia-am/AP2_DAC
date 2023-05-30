package beans;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import daos.IncidenteDAO;
import entidades.Incidente;
import entidades.Usuario;

@ManagedBean
@RequestScoped
public class IncidenteBean {

	private IncidenteDAO incidenteDAO;
	private List<Incidente> incidentes;
	private LoginBean usuarioBean = new LoginBean();
    private Incidente incidente;

	@PostConstruct
	public void init() {
		incidenteDAO = new IncidenteDAO();
		incidentes = incidenteDAO.listarTodos();
	}
	

    public IncidenteBean() {
        incidente = new Incidente();
    }

    public Incidente getIncidente() {
        return incidente;
    }

    public void setIncidente(Incidente incidente) {
        this.incidente = incidente;
    }

    public void cadastrarIncidente() {
        incidente.setData(new Date());
        IncidenteDAO incidenteDAO = new IncidenteDAO();
        incidenteDAO.salvar(incidente);
        incidente = new Incidente();
        
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
		try {
			externalContext.redirect(request.getContextPath() + "/listagem_incidente.xhtml");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

	
	public List<Incidente> getIncidentes() {
		if (incidentes == null) {
			incidenteDAO = new IncidenteDAO();
			incidentes = incidenteDAO.listarTodos();
		}
		return incidentes;
	}
	
    public void visualizarIncidente(Integer id) {
        Incidente incidente = incidenteDAO.buscarPorId(id);
    }

    public void editarIncidente(Integer id) {
        Incidente incidente = incidenteDAO.buscarPorId(id);
    }
}