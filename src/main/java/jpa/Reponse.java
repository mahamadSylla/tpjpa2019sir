package jpa;

import java.util.Collection;

public class Reponse {
	private int idSondage;
	private int idUtilisateur;
	private Collection<ChoixDate> choixDates;
	/**
	 * @return the idSondage
	 */
	public int getIdSondage() {
		return idSondage;
	}
	/**
	 * @param idSondage the idSondage to set
	 */
	public void setIdSondage(int idSondage) {
		this.idSondage = idSondage;
	}
	/**
	 * @return the idUtilisateur
	 */
	public int getIdUtilisateur() {
		return idUtilisateur;
	}
	/**
	 * @param idUtilisateur the idUtilisateur to set
	 */
	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
	/**
	 * @return the choixDates
	 */
	public Collection<ChoixDate> getChoixDates() {
		return choixDates;
	}
	/**
	 * @param choixDates the choixDates to set
	 */
	public void setChoixDates(Collection<ChoixDate> choixDates) {
		this.choixDates = choixDates;
	}
	
	
}
