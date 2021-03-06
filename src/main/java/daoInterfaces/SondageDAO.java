package daoInterfaces;

import java.util.Collection;

import jpa.ChoixDate;
import jpa.Reponse;
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
	
	public void supprimerSondage(int idSondage);
	
	public Sondage updateSondage(Sondage sondage);

	public ChoixDate creerUnePlageHoraire(ChoixDate plageHoraire);
	
	public ChoixDate getChoixDateById(int idChoixDate);

	public Sondage validerUneDate(int idSondage, int IdChoixDate);

	public Collection<ReponseSondage> reponses(int idSondage);
	
	public Collection<ChoixDate> datesProposees(int idSondage);
	
	public ReponseSondage repondreSondage(ReponseSondage reponse);

	public ChoixDate ajouterUneDate_A_UnSondage(int idSondage, int idChoixDate);

	public Collection<Utilisateur> getParticipantsByIdSondage(int idSondage);

	public Collection<ChoixDate> plages();
	
	public ReponseSondage reponse(Reponse reponse);

}
