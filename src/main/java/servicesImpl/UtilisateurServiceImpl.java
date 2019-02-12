package servicesImpl;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.UtilisateurDAO;
import daoImpl.UtilisateurDaoImpl;
import jpa.Alergies;
import jpa.Reunion;
import jpa.Role;
import jpa.Sondage;
import jpa.Utilisateur;
import services.UtilisateurService;

@Path("/home")
public class UtilisateurServiceImpl implements UtilisateurService{
	
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

	
	private UtilisateurDAO utilisateurDAO;
	public UtilisateurServiceImpl() {
		this.utilisateurDAO = new UtilisateurDaoImpl();
	}

	public void createUtilisateur(Utilisateur user) {
		//this.utilisateurDAO.createUtilisateur(user);
		
	}

	public void listUtilisateurs() {
		// TODO Auto-generated method stub
		
	}

	public Role role(UtilisateurDAO utilisateur) {
		// TODO Auto-generated method stub
		return null;
	}

	public void ajouterRole(UtilisateurDAO utilisateur) {
		// TODO Auto-generated method stub
		
	}

	public Collection<Sondage> sondagesCrees() {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection<Alergies> alergies(UtilisateurDAO utilisateur) {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection<Reunion> reunionsAssistees(UtilisateurDAO utilisateur) {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection<Sondage> sondagesParticipes(UtilisateurDAO utilisateur) {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection<String> preferencesAlimentaire(UtilisateurDAO utilisateur, Reunion reunion) {
		// TODO Auto-generated method stub
		return null;
	}

}
