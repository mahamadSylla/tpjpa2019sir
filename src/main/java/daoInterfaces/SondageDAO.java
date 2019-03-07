package daoInterfaces;

import java.util.Collection;

import jpa.ChoixDate;
import jpa.ReponseSondage;
import jpa.Reunion;
import jpa.Sondage;
import jpa.Utilisateur;

public interface SondageDAO {
	public Collection<Sondage> listSondage();

	public Sondage sondage(int idSondage);

	public Utilisateur createurSondage(int idSondage);

	public void creerSondage(int idUser, Sondage sondage);

	public void creerUnePlageHoraire(ChoixDate plageHoraire);

	public void validerUneDate(int idSondage, int IdChoixDate);

	public Collection<ReponseSondage> datesProposees(int idSondage);

	public void ajouterUneDate_A_UnSondage(int idSondage, int idChoixDate);

	public void choisirUneDate(int idReponseSondage, int idChoixDate);

	public void repondreSondage(int idUser, int idSondage, ReponseSondage reponse);

}
