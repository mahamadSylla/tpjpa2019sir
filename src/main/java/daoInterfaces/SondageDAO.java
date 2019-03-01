package daoInterfaces;

import java.sql.Date;
import java.util.Collection;

import jpa.Sondage;
import jpa.Utilisateur;

public interface SondageDAO {
	public void sondage();

	public void listSondage();

	public void creerSondage(Sondage sondage);

	public void dateRetenue(Sondage sondage);

	public void datesProposees(Sondage sondage);

	public void createurSondage(Sondage sondage);

	public void validerUneDate(Date date);
}
