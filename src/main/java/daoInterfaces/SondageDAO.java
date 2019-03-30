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
	
	public Reunion getReunionByIdSondage(int idSondage);

	public Sondage creerSondage(int idUser, Sondage sondage);

	public ChoixDate creerUnePlageHoraire(ChoixDate plageHoraire);

	public Sondage validerUneDate(int idSondage, int IdChoixDate);

	public Collection<ReponseSondage> datesProposees(int idSondage);
	
	public ReponseSondage repondreSondage(ReponseSondage reponse);

	public ChoixDate ajouterUneDate_A_UnSondage(int idSondage, int idChoixDate);

	public Collection<Utilisateur> getParticipantsByIdSondage(int idSondage);


}
