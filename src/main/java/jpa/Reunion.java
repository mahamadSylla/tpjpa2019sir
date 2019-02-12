/**
 * 
 */
package jpa;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
	private ChoixDate dateReunion;
	private Sondage sondage;
	private Collection<Utilisateur> participants;

	public Reunion() {
		this.participants = new HashSet<Utilisateur>();
	}

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue
	@Column(name = "idReunion")
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
	 * @return the resume
	 */
	public String getResume() {
		return resume;
	}

	/**
	 * @param resume
	 *            the resume to set
	 */
	public void setResume(String resume) {
		this.resume = resume;
	}

	/**
	 * @return the dateReunion
	 */
	public ChoixDate getDateReunion() {
		return dateReunion;
	}

	/**
	 * @param dateReunion
	 *            the dateReunion to set
	 */
	public void setDateReunion(ChoixDate dateReunion) {
		this.dateReunion = dateReunion;
	}

	/**
	 * 
	 */
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {CascadeType.MERGE, CascadeType.PERSIST}
			)
	@JoinTable(name="reunion_utilisateur",
	joinColumns = @JoinColumn(name="fk_reunion"),
	inverseJoinColumns = @JoinColumn(name = "fk_utilisateur")
	)
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
	 * @return the sondage
	 */
	@OneToOne
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

}
