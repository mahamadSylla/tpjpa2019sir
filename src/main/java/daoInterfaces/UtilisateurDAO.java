package daoInterfaces;

import java.util.Collection;

import jpa.Alergies;
import jpa.ChoixDate;
import jpa.PreferenceAlimentaire;
import jpa.ReponseSondage;
import jpa.Reunion;
import jpa.Role;
import jpa.Sondage;
import jpa.Utilisateur;

public interface UtilisateurDAO {
	public Utilisateur utilisateur(int userId);

	public Utilisateur creerUtilisateur(Utilisateur user);
	
	public Utilisateur updateUtilisateur(Utilisateur user);
	
	public void supprimerUtilisateur(int userId);
	
	public Collection<Utilisateur> listUtilisateurs();

	public Role ajouterRole(int userId, Role r);
	
	public void supprimerRole(int roleId);
	
	public void updateRole(Role role);
	
	public Collection<Role> roles(int userId);

	public PreferenceAlimentaire ajouterPreference(int userId, int reunionId, PreferenceAlimentaire p);

	public Collection<Sondage> sondagesCrees(int userId);
	
	public void ajouterAlergie(int userId, Alergies a);
	
	public void supprimerAlergie(int userId, int alergieId);
	
	public void updateAlergie(Alergies alergie);

	public Collection<Alergies> alergies(int userId);

	public Collection<Reunion> reunionsAssistees(int userId);

	public Collection<Reunion> reunionsManquees(int userId);

	public Collection<ReponseSondage> sondagesParticipes(int userId);

	public Collection<PreferenceAlimentaire> preferencesAlimentaire(int userId, int idReunion);

	public Collection<ChoixDate> reponseA_unSondage(int userId, int idSondage);

}
