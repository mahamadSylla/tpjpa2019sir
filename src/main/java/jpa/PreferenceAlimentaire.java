/**
 * 
 */
package jpa;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * @author Mahamadou SYLLA
 *
 */

@Entity
public class PreferenceAlimentaire {
	private Utilisateur participant;
	private Reunion reunion;
	Collection<String> preferences;
	
	/**
	 * 
	 */
	public PreferenceAlimentaire() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the participant
	 */
	@OneToOne
	public Utilisateur getParticipant() {
		return participant;
	}

	/**
	 * @param participant the participant to set
	 */
	public void setParticipant(Utilisateur participant) {
		this.participant = participant;
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
	 * @return the preferences
	 */
	public Collection<String> getPreferences() {
		return preferences;
	}

	/**
	 * @param preferences the preferences to set
	 */
	public void setPreferences(Collection<String> preferences) {
		this.preferences = preferences;
	}

}
