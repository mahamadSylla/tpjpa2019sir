package jpa;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

//@Entity
public class Sondage {
	private long id;
	private String intitule;
	private String participatedWebLink;
	private String chooseFoodWebLink;
	private Collection<ChoixDate> dates;
	private Reunion reunion;
	private Utilisateur createur;
	private Collection<Utilisateur> participants;

	public Sondage() {
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
	 * @return the intitule
	 */
	public String getIntitule() {
		return intitule;
	}

	/**
	 * @param intitule
	 *            the intitule to set
	 */
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	/**
	 * @return the chooseFoodWebLink
	 */
	public String getChooseFoodWebLink() {
		return chooseFoodWebLink;
	}

	/**
	 * @param chooseFoodWebLink
	 *            the chooseFoodWebLink to set
	 */
	public void setChooseFoodWebLink(String chooseFoodWebLink) {
		this.chooseFoodWebLink = chooseFoodWebLink;
	}

	/**
	 * @return the participants
	 */
	// @OneToMany(mappedBy = "sondages")
	@ManyToMany
	public Collection<Utilisateur> getParticipants() {
		return participants;
	}

	/**
	 * @param participants
	 *            the participants to set
	 */
	public void setParticipants(Collection<Utilisateur> participants) {
		this.participants = participants;
	}

	/**
	 * @return the participatedWebLink
	 */
	public String getParticipatedWebLink() {
		return participatedWebLink;
	}

	/**
	 * @param participatedWebLink
	 *            the participatedWebLink to set
	 */
	public void setParticipatedWebLink(String participatedWebLink) {
		this.participatedWebLink = participatedWebLink;
	}

	/**
	 * @return the chosseFoodWebLink
	 */
	public String getChosseFoodWebLink() {
		return chooseFoodWebLink;
	}

	/**
	 * @param chosseFoodWebLink
	 *            the chosseFoodWebLink to set
	 */
	public void setChosseFoodWebLink(String chosseFoodWebLink) {
		this.chooseFoodWebLink = chosseFoodWebLink;
	}

	/**
	 * @return the dates
	 */
	@OneToMany
	@JoinColumn(name="sondage_id")
	public Collection<ChoixDate> getDates() {
		return dates;
	}

	/**
	 * @param dates
	 *            the dates to set
	 */
	public void setDates(Collection<ChoixDate> dates) {
		this.dates = dates;
	}

	/**
	 * @return the reunion
	 */
	@OneToOne
	public Reunion getReunion() {
		return reunion;
	}

	/**
	 * @param reunion
	 *            the reunion to set
	 */
	public void setReunion(Reunion reunion) {
		this.reunion = reunion;
	}

	/**
	 * @return the createur
	 */
	@ManyToOne
	public Utilisateur getCreateur() {
		return createur;
	}

	/**
	 * @param createur
	 *            the createur to set
	 */
	public void setCreateur(Utilisateur createur) {
		this.createur = createur;
	}
}
