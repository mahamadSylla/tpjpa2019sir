package daoInterfaces;

import java.util.Collection;

import jpa.Utilisateur;
import jpa.Reunion;
import jpa.Sondage;;

public interface ReunionDAO {
	public Reunion reunion(int idReunion);

	public Sondage sondage(int idReunion);

	public Collection<Reunion> listReunion();

	public void creerReunion(Reunion reunion);

	public Collection<Utilisateur> presents(int idReunion);

	public Collection<Utilisateur> absents(int idReunion);
}
