/**
 * 
 */
package jpa;

import java.util.Collection;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;

/**
 * @author Mahamadou SYLLA
 *
 */

//@Entity
public class PreferenceAlimentaire {
	
	@Id
	@GeneratedValue
	private int id;
	
	
	
	//private Utilisateur participant;
	//private Reunion reunion;
	//@EmbeddedId
	//private PreferenceId id;

	/**
	 * @return the id
	 */
	/*public PreferenceId getId() {
		return id;
	}*/


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param id the id to set
	 */
	/*public void setId(PreferenceId id) {
		this.id = id;
	}*/

	//private Collection<String> preferences;

	/**
	 * 
	 */
	public PreferenceAlimentaire() {
	}


	/**
	 * @return the participant
	 */
	//@OneToOne
	//@JoinColumns(@JoinColumn(name = "idParticipant", referencedColumnName = "idParticipant"))
	/*public Utilisateur getParticipant() {
		return participant;
	}*/

	/**
	 * @param participant
	 *            the participant to set
	 */
	/*public void setParticipant(Utilisateur participant) {
		this.participant = participant;
	}*/

	/**
	 * @return the reunion
	 */
	/*@OneToOne
	@JoinColumns(@JoinColumn(name = "idReunion", referencedColumnName = "idReunion"))
	public Reunion getReunion() {
		return reunion;
	}*/

	/**
	 * @param reunion
	 *            the reunion to set
	 */
	/*public void setReunion(Reunion reunion) {
		this.reunion = reunion;
	}*/

	/**
	 * @return the preferences
	 */
	/*public Collection<String> getPreferences() {
		return preferences;
	}*/

	/**
	 * @param preferences
	 *            the preferences to set
	 */
	/*public void setPreferences(Collection<String> preferences) {
		this.preferences = preferences;
	}*/
}
