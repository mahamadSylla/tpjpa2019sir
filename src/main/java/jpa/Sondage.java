package jpa;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Sondage {
	private long id;
	private String participatedWebLink;
	private String chosseFoodWebLink;
	Collection<ChoixDate> dates;
	private Reunion reunion;
	private Utilisateur createur;
	
	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	
	/**
	 * @return the participatedWebLink
	 */
	public String getParticipatedWebLink() {
		return participatedWebLink;
	}
	/**
	 * @param participatedWebLink the participatedWebLink to set
	 */
	public void setParticipatedWebLink(String participatedWebLink) {
		this.participatedWebLink = participatedWebLink;
	}
	/**
	 * @return the chosseFoodWebLink
	 */
	public String getChosseFoodWebLink() {
		return chosseFoodWebLink;
	}
	/**
	 * @param chosseFoodWebLink the chosseFoodWebLink to set
	 */
	public void setChosseFoodWebLink(String chosseFoodWebLink) {
		this.chosseFoodWebLink = chosseFoodWebLink;
	}
	/**
	 * @return the dates
	 */
	@OneToMany(mappedBy = "sondage")
	public Collection<ChoixDate> getDates() {
		return dates;
	}
	/**
	 * @param dates the dates to set
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
	 * @param reunion the reunion to set
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
	 * @param createur the createur to set
	 */
	public void setCreateur(Utilisateur createur) {
		this.createur = createur;
	}
	
	
}
