package daoInterfaces;

import java.util.Collection;

import jpa.Alergies;
import jpa.Preference;
import jpa.ReponseSondage;
import jpa.Reunion;
import jpa.Role;
import jpa.Sondage;
import jpa.Utilisateur;

public interface UtilisateurDAO {
	public void creerUtilisateur(Utilisateur user);

	public Collection<Utilisateur> listUtilisateurs();

	public void ajouterRole(int userId, Role r);

	public Collection<Sondage> sondagesCrees(int userId);

	public Collection<Alergies> alergies(int userId);

	public Collection<Reunion> reunionsAssistees(int userId);

	public Collection<ReponseSondage> sondagesParticipes(int userId);

	public Collection<Preference> preferencesAlimentaire(int userId, int idReunion);
	
	public Collection<ReponseSondage> reponseA_unSondage(int userId, int idSondage);

}
