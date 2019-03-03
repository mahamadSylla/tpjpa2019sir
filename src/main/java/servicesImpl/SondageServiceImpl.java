package servicesImpl;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import daoImpl.SondageDaoImpl;
import daoInterfaces.SondageDAO;
import jpa.ChoixDate;
import jpa.ReponseSondage;
import jpa.Sondage;
import jpa.Utilisateur;
import services.SondageService;

@Path("/sondages")
public class SondageServiceImpl implements SondageService {
	private SondageDAO sondageDAO;

	public SondageServiceImpl() {
		this.sondageDAO = new SondageDaoImpl();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Sondage> listSondage() {
		return sondageDAO.listSondage();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Sondage sondage(@PathParam("id") int idSondage) {
		return sondageDAO.sondage(idSondage);
	}

	@POST
	@Path("{id}/creer")
	@Consumes(MediaType.APPLICATION_JSON)
	public void creerSondage(@PathParam("id") int idUser, Sondage sondage) {
		sondageDAO.creerSondage(idUser, sondage);
	}

	@GET
	@Path("{id}/createur")
	@Produces(MediaType.APPLICATION_JSON)
	public Utilisateur createurSondage(@PathParam("id") int idSondage) {
		return sondageDAO.createurSondage(idSondage);
	}

	@POST
	@Path("{id}/valider")
	@Consumes(MediaType.APPLICATION_JSON)
	public void validerUneDate(@PathParam("id") int idSondage, ChoixDate date) {
		sondageDAO.validerUneDate(idSondage, date);
	}
	
	@GET
	@Path("{id}/reponses")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<ReponseSondage> datesProposees(@PathParam("id") int idSondage) {
		return sondageDAO.datesProposees(idSondage);
	}

}
