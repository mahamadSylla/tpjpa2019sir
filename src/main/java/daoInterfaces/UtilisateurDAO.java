package daoInterfaces;

import java.util.Collection;

import jpa.Alergies;
import jpa.ChoixDate;
import jpa.Preference;
import jpa.PreferenceAlimentaire;
import jpa.ReponseSondage;
import jpa.Reunion;
import jpa.Role;
import jpa.Sondage;
import jpa.Utilisateur;

public interface UtilisateurDAO {
	public void creerUtilisateur(Utilisateur user);

	public Collection<Utilisateur> listUtilisateurs();

	public void ajouterRole(int userId, Role r);

	public void ajouterPreference(int userId, int reunionId, PreferenceAlimentaire p);

	public Collection<Sondage> sondagesCrees(int userId);

	public Collection<Alergies> alergies(int userId);

	public Collection<Reunion> reunionsAssistees(int userId);

	public Collection<Reunion> reunionsManquees(int userId);

	public Collection<ReponseSondage> sondagesParticipes(int userId);

	public Collection<PreferenceAlimentaire> preferencesAlimentaire(int userId, int idReunion);

	public Collection<ChoixDate> reponseA_unSondage(int userId, int idSondage);

}
