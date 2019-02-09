package servicesImpl;

import java.util.Collection;

import dao.UtilisateurDAO;
import jpa.Alergies;
import jpa.Reunion;
import jpa.Role;
import jpa.Sondage;
import jpa.Utilisateur;
import services.UtilisateurService;

public class UtilisateurServiceImpl implements UtilisateurService{

	private UtilisateurDAO utilisateur;
	public UtilisateurServiceImpl() {
		this.utilisateur = new UtilisateurServiceImpl();
	}

	public void createUtilisateur(Utilisateur user) {
		this.utilisateur.createUtilisateur(user);
		
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
