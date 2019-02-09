/**
 * 
 */
package jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author Mahamadou SYLLA
 *
 */
@Entity
public class Alergies {

	private long id;
	private String name;
	private Utilisateur participant;

	/**
	 * 
	 */
	public Alergies() {
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the participant
	 */
	@ManyToOne
	public Utilisateur getParticipant() {
		return participant;
	}

	/**
	 * @param participant
	 *            the participant to set
	 */
	public void setParticipant(Utilisateur participant) {
		this.participant = participant;
	}

}
