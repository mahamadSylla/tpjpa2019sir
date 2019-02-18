package dao;

import java.util.Collection;

import jpa.Alergies;
import jpa.Reunion;
import jpa.Role;
import jpa.Sondage;
import jpa.Utilisateur;

public interface UtilisateurDAO {
	public void createUtilisateur(Utilisateur user);

	public Collection<Utilisateur> listUtilisateurs();

	public Role role(UtilisateurDAO utilisateur);

	public void ajouterRole(UtilisateurDAO utilisateur);

	public Collection<Sondage> sondagesCrees();

	public Collection<Alergies> alergies(UtilisateurDAO utilisateur);

	public Collection<Reunion> reunionsAssistees(UtilisateurDAO utilisateur);

	public Collection<Sondage> sondagesParticipes(UtilisateurDAO utilisateur);

	public Collection<String> preferencesAlimentaire(UtilisateurDAO utilisateur, Reunion reunion);

}
