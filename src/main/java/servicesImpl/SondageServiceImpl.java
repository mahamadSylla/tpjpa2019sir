package servicesImpl;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import daoImpl.SondageDaoImpl;
import daoInterfaces.SondageDAO;
import jpa.ChoixDate;
import jpa.Reponse;
import jpa.ReponseSondage;
import jpa.Reunion;
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
	public Sondage creerSondage(@PathParam("id") int idUser, Sondage sondage) {
		return sondageDAO.creerSondage(idUser, sondage);
	}

	@GET
	@Path("{id}/createur")
	@Produces(MediaType.APPLICATION_JSON)
	public Utilisateur createurSondage(@PathParam("id") int idSondage) {
		return sondageDAO.createurSondage(idSondage);
	}

	@POST
	@Path("{id1}/{id2}/valider")
	public Sondage validerUneDate(@PathParam("id1") int idSondage, @PathParam("id2") int idChoixDate) {
		return sondageDAO.validerUneDate(idSondage, idChoixDate);
	}
	
	@GET
	@Path("{id}/reponses")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<ReponseSondage> reponses(@PathParam("id") int idSondage) {
		return sondageDAO.reponses(idSondage);
	}

	@POST
	@Path("{id1}/{id2}/repondre")
	@Consumes(MediaType.APPLICATION_JSON)
	public ReponseSondage repondreSondage(ReponseSondage reponse) {
		return sondageDAO.repondreSondage(reponse);
	}

	@POST
	@Path("/creerPlageHoraire")
	@Consumes(MediaType.APPLICATION_JSON)
	public ChoixDate creerUnePlageHoraire(ChoixDate plageHoraire) {
		return sondageDAO.creerUnePlageHoraire(plageHoraire);
		
	}

	@POST
	@Path("{id1}/{id2}/ajouterUneDate")
	@Consumes(MediaType.APPLICATION_JSON)
	public ChoixDate ajouterUneDate_A_UnSondage(@PathParam("id1") int idSondage, @PathParam("id2") int idChoixDate) {
		return sondageDAO.ajouterUneDate_A_UnSondage(idSondage, idChoixDate);
		
	}
	@GET
	@Path("/{id}/participants")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Utilisateur> getParticipantsByIdSondage(@PathParam("id") int idSondage) {
		return sondageDAO.getParticipantsByIdSondage(idSondage);
	}

	@GET
	@Path("/{id}/reunion")
	@Produces(MediaType.APPLICATION_JSON)
	public Reunion getReunionByIdSondage(@PathParam("id") int idSondage) {
		return sondageDAO.getReunionByIdSondage(idSondage);
	}

	@GET
	@Path("/allPlages")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<ChoixDate> plages() {
		return sondageDAO.plages();
	}

	@DELETE
	@Path("{id}/delete")
	public void supprimerSondage(@PathParam("id") int idSondage) {
		 this.sondageDAO.supprimerSondage(idSondage);
		
	}
	
	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Sondage updateSondage(Sondage sondage) {
		return this.sondageDAO.updateSondage(sondage);
	}

	@GET
	@Path("/choixDate/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ChoixDate getChoixDateById(@PathParam("id") int idChoixDate) {
		return sondageDAO.getChoixDateById(idChoixDate);
	}

	@GET
	@Path("{id}/datesProposees")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<ChoixDate> datesProposees(@PathParam("id") int idSondage) {
		return this.sondageDAO.datesProposees(idSondage);
	}

	@PUT
	@Path("/mesReponses")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ReponseSondage reponse(Reponse reponse) {
		return this.sondageDAO.reponse(reponse);
	}
		
}
