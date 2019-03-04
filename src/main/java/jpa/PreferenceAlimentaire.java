/**
 * 
 */
package jpa;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * @author Mahamadou SYLLA
 *
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findPreferencesByUserAndMeeting", query = "SELECT p FROM PreferenceAlimentaire p "
				+ "WHERE p.id.idParticipant = :idParticipant AND p.id.idReunion = :idReunion"),
		@NamedQuery(name = "findPreferencesByUser", query = "SELECT p FROM PreferenceAlimentaire p "
				+ "WHERE p.id.idParticipant = :idParticipant"),
		@NamedQuery(name = "findPreferencesByMeeting", query = "SELECT p FROM PreferenceAlimentaire p "
				+ "WHERE p.id.idReunion = :idReunion")
		})
public class PreferenceAlimentaire {
	@EmbeddedId
	private PreferenceId id;
	private String preference;

	/**
	 * constructor method
	 */
	public PreferenceAlimentaire() {
	}

	/**
	 * @return the id
	 */
	public PreferenceId getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(PreferenceId id) {
		this.id = id;
	}

	/**
	 * @return the preference
	 */
	public String getPreference() {
		return preference;
	}

	/**
	 * @param preference
	 *            the preference to set
	 */
	public void setPreference(String preference) {
		this.preference = preference;
	}
}
