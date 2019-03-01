package servicesImpl;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import daoImpl.UtilisateurDaoImpl;
import daoInterfaces.UtilisateurDAO;
import jpa.Alergies;
import jpa.Preference;
import jpa.ReponseSondage;
import jpa.Reunion;
import jpa.Role;
import jpa.Sondage;
import jpa.Utilisateur;
import services.UtilisateurService;

@Path("/utilisateurs")
public class UtilisateurServiceImpl implements UtilisateurService {
	/*
	 * @GET
	 * 
	 * @Produces(MediaType.APPLICATION_JSON) public Utilisateur getUser() {
	 * Utilisateur u = new Utilisateur(); Role r = new Role();
	 * r.setName("participant"); u.setName("toto"); u.setFirstName("tonton");
	 * u.setMail("mahamadsylla5@gmail.com"); u.setRole(r); return u; }
	 */

	private UtilisateurDAO utilisateurDAO;

	public UtilisateurServiceImpl() {
		this.utilisateurDAO = new UtilisateurDaoImpl();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Utilisateur> listUtilisateurs() {
		return utilisateurDAO.listUtilisateurs();
	}

	@POST
	@Path("/creerUtilisateur")
	@Consumes(MediaType.APPLICATION_JSON)
	public void creerUtilisateur(Utilisateur user) {
		this.utilisateurDAO.creerUtilisateur(user);
	}

	@POST
	@Path("{id}/ajouterRole")
	@Consumes(MediaType.APPLICATION_JSON)
	public void ajouterRole(@PathParam("id") int userId, Role r) {
		utilisateurDAO.ajouterRole(userId, r);
	}

	@GET
	@Path("{id}/sondagesCrees")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Sondage> sondagesCrees(@PathParam("id") int userId) {
		return utilisateurDAO.sondagesCrees(userId);
	}

	@GET
	@Path("{id}/alergies")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Alergies> alergies(@PathParam("id") int userId) {
		return utilisateurDAO.alergies(userId);
	}

	@GET
	@Path("/{id}/reunionsAssistees")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Reunion> reunionsAssistees(@PathParam("id") int userId) {
		return utilisateurDAO.reunionsAssistees(userId);
	}

	@GET
	@Path("/{id1}/{id2}/preferences")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Preference> preferencesAlimentaire(@PathParam("id1") int userId, @PathParam("id2") int meetingId) {
		return utilisateurDAO.preferencesAlimentaire(userId, meetingId);
	}

	@GET
	@Path("/{id1}/{id2}/reponsesSondage")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<ReponseSondage> reponseA_unSondage(@PathParam("id1") int userId, @PathParam("id") int idSondage) {
		return utilisateurDAO.reponseA_unSondage(userId, idSondage);
	}

	@GET
	@Path("{id}/sondageParticipes")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<ReponseSondage> sondagesParticipes(@PathParam("id") int userId) {
		return utilisateurDAO.sondagesParticipes(userId);
	}

}
