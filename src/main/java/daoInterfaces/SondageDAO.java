package daoInterfaces;

import java.util.Collection;

import jpa.ChoixDate;
import jpa.ReponseSondage;
import jpa.Sondage;
import jpa.Utilisateur;

public interface SondageDAO {
	public Collection<Sondage> listSondage();

	public Sondage sondage(int idSondage);

	public void creerSondage(int idUser, Sondage sondage);

	public Utilisateur createurSondage(int idSondage);

	public void validerUneDate(int idSondage, int IdChoixDate);

	public Collection<ReponseSondage> datesProposees(int idSondage);

	public void repondreSondage(int idUser, int idSondage, ReponseSondage reponse);

}
