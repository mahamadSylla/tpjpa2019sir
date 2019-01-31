/**
 * 
 */
package jpa;

import java.sql.Date;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

/**
 * @author Mahamadou SYLLA
 *
 */
@Entity
public class Reunion {
	private long id;
	private String intitule;
	private String resume;
	private Date dateReunion;
	private Sondage sondage;
	Collection<Utilisateur> participants;
	
	@Id
	@GeneratedValue
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @return the intitule
	 */
	public String getIntitule() {
		return intitule;
	}
	/**
	 * @param intitule the intitule to set
	 */
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	/**
	 * @return the resume
	 */
	public String getResume() {
		return resume;
	}
	/**
	 * @param resume the resume to set
	 */
	public void setResume(String resume) {
		this.resume = resume;
	}
	/**
	 * @return the dateReunion
	 */
	public Date getDateReunion() {
		return dateReunion;
	}
	/**
	 * @param dateReunion the dateReunion to set
	 */
	public void setDateReunion(Date dateReunion) {
		this.dateReunion = dateReunion;
	}
	/**
	 * @return the participants
	 */
	@ManyToMany
	public Collection<Utilisateur> getParticipants() {
		return participants;
	}
	/**
	 * @param participants the participants to set
	 */
	public void setParticipants(Collection<Utilisateur> participants) {
		this.participants = participants;
	}
	/**
	 * @return the sondage
	 */
	@OneToOne
	public Sondage getSondage() {
		return sondage;
	}
	/**
	 * @param sondage the sondage to set
	 */
	public void setSondage(Sondage sondage) {
		this.sondage = sondage;
	}
	
	
}
