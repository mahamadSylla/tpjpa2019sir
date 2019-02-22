package servicesImpl;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.UtilisateurDAO;
import daoImpl.UtilisateurDaoImpl;
import jpa.Alergies;
import jpa.Preference;
import jpa.ReponseSondage;
import jpa.Reunion;
import jpa.Role;
import jpa.Sondage;
import jpa.Utilisateur;
import services.UtilisateurService;

@Path("/utilisateurs")
public class UtilisateurServiceImpl implements UtilisateurService{
/*
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Utilisateur getUser() {
		Utilisateur u = new Utilisateur();
		Role r = new Role();
		r.setName("participant");
		u.setName("toto");
		u.setFirstName("tonton");
		u.setMail("mahamadsylla5@gmail.com");
		u.setRole(r);
		return u;
	}
*/

	private UtilisateurDAO utilisateurDAO;
	public UtilisateurServiceImpl() {
		this.utilisateurDAO = new UtilisateurDaoImpl();
	}

	public void createUtilisateur(Utilisateur user) {
		this.utilisateurDAO.createUtilisateur(user);
		
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Utilisateur> listUtilisateurs() {
		return utilisateurDAO.listUtilisateurs();
		
	}

	public void ajouterRole(int userId, Role r) {
		utilisateurDAO.ajouterRole(userId, r);
		
	}

	public Collection<Sondage> sondagesCrees(int userId) {
		return utilisateurDAO.sondagesCrees(userId);
	}
	@Path("/alergies")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Alergies> alergies(int userId) {
		return utilisateurDAO.alergies(userId);
	}

	public Collection<Reunion> reunionsAssistees(int userId) {
		return utilisateurDAO.reunionsAssistees(userId);
	}
	public Collection<Preference> preferencesAlimentaire(int userId, int meetingId) {
		return utilisateurDAO.preferencesAlimentaire(userId, meetingId);
	}

	public Collection<ReponseSondage> reponseA_unSondage(int userId, int surveyId) {
		return utilisateurDAO.reponseA_unSondage(userId, surveyId);
	}

	public Collection<ReponseSondage> sondagesParticipes(int userId) {
		return utilisateurDAO.sondagesParticipes(userId);
	}

}
