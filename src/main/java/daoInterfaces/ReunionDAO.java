package daoInterfaces;

import java.util.Collection;
import jpa.Utilisateur;
import jpa.PreferenceAlimentaire;
import jpa.Reunion;
import jpa.Sondage;;

public interface ReunionDAO {
	public Reunion reunion(int idReunion);

	public Sondage sondage(int idReunion);

	public Collection<Reunion> listReunion();

	public Reunion creerReunion(int idSondage, Reunion reunion);

	public Collection<Utilisateur> presents(int idReunion);

	public Collection<Utilisateur> absents(int idReunion);

	public Collection<PreferenceAlimentaire> preferencesAlimentaire(int idReunion);
	
}
