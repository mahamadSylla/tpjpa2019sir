package jpa;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ReponseSondage {
	private long id;
	private Utilisateur utilisateur;
	private Sondage sondage;
	private Collection<ChoixDate> choixDonnes;

	public ReponseSondage() {
		this.choixDonnes = new HashSet<ChoixDate>();
	}

	/**
	 * 
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
	@ManyToOne
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
	@ManyToOne
	@JoinColumn(name="sondage_id")
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
	@OneToMany
	@JoinColumn(name="reponseId")
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

	/**
	 * @param date
	 *            the date to add
	 */
	public void addChoix(ChoixDate date) {
		Objects.requireNonNull(date, "La date ne doit pas �tre nulle");
		this.choixDonnes.add(date);
	}

	/**
	 * @param date
	 *            the date to remove
	 */
	public boolean removeChoix(ChoixDate date) {
		Objects.requireNonNull(date, "Ne doit pas �tre vide");
		if (!this.choixDonnes.contains(date)) {
			return false;
		}
		return this.choixDonnes.remove(date);
	}
}
