package jpa;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

//@Entity
public class ReponseSondage {
	private long id;
	private Utilisateur utilisateur;
	private Sondage sondage;
	private Collection<ChoixDate> choixDonnes;

	public ReponseSondage() {
		this.choixDonnes = new HashSet<ChoixDate>();

	}

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the utilisateur
	 */
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	/**
	 * @param utilisateur
	 *            the utilisateur to set
	 */
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	/**
	 * @return the sondage
	 */
	public Sondage getSondage() {
		return sondage;
	}

	/**
	 * @param sondage
	 *            the sondage to set
	 */
	public void setSondage(Sondage sondage) {
		this.sondage = sondage;
	}

	/**
	 * @return the choixDonnes
	 */
	@ManyToMany
	public Collection<ChoixDate> getChoixDonnes() {
		return choixDonnes;
	}

	/**
	 * @param choixDonnes
	 *            the choixDonnes to set
	 */
	public void setChoixDonnes(Collection<ChoixDate> choixDonnes) {
		this.choixDonnes = choixDonnes;
	}

}
