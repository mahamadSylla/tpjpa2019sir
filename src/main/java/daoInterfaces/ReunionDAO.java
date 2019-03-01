package daoInterfaces;

import java.util.Collection;

import jpa.Utilisateur;
import jpa.Sondage;;

public interface ReunionDAO {
	public void reunion();

	public Sondage sondage();

	public void listReunion();

	public void createReunion();
	
	public Collection<Utilisateur> participants();
}
