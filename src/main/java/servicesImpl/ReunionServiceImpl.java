package servicesImpl;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import daoImpl.ReunionDaoImpl;
import daoInterfaces.ReunionDAO;
import jpa.PreferenceAlimentaire;
import jpa.Reunion;
import jpa.Sondage;
import jpa.Utilisateur;
import services.ReunionService;

@Path("/reunions")
public class ReunionServiceImpl implements ReunionService {
	private ReunionDAO reunionDAO;

	public ReunionServiceImpl() {
		this.reunionDAO = new ReunionDaoImpl();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Reunion reunion(@PathParam("id") int idReunion) {
		return reunionDAO.reunion(idReunion);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Reunion> listReunion() {
		return reunionDAO.listReunion();
	}

	@GET
	@Path("{id}/sondage")
	@Produces(MediaType.APPLICATION_JSON)
	public Sondage sondage(@PathParam("id") int idReunion) {
		return reunionDAO.sondage(idReunion);
	}

	@POST
	@Path("{id}/creer")
	@Consumes(MediaType.APPLICATION_JSON)
	public void creerReunion(@PathParam("id") int idSondage, Reunion reunion) {
		reunionDAO.creerReunion(idSondage, reunion);

	}

	@GET
	@Path("/{id}/presents")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Utilisateur> presents(@PathParam("id") int idReunion) {
		return reunionDAO.presents(idReunion);
	}

	@GET
	@Path("/{id}/absents")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Utilisateur> absents(@PathParam("id") int idReunion) {
		return reunionDAO.absents(idReunion);
	}

	@GET
	@Path("/{id}/preferences")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<PreferenceAlimentaire> preferencesAlimentaire(@PathParam("id") int idReunion) {
		return reunionDAO.preferencesAlimentaire(idReunion);
	}

}
