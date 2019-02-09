package dao;

import java.sql.Date;
import java.util.Collection;
import jpa.Utilisateur;

public interface SondageDAO {
	public void sondage();

	public void listSondage();

	public void createSondage();

	public void dateRetenue();

	public void datesProposees();

	public void createurSondage();

	public void validerUneDate(Date date);

	public Collection<Utilisateur> participants();
}
