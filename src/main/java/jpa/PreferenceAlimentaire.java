/**
 * 
 */
package jpa;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * @author Mahamadou SYLLA
 *
 */

//@Entity
public class PreferenceAlimentaire {
	// private long id;
	// @Id
	// @GeneratedValue
	// private int id;
	/**
	 * @return the id
	 * 
	 *         public int getId() { return id; }
	 * 
	 */

	/**
	 * @param id
	 *            the id to set
	 * 
	 *            public void setId(int id) { this.id = id; }
	 */

	//private Utilisateur participant;
	//private Reunion reunion;
	@EmbeddedId
	private PreferenceId id;
	@OneToMany
	@JoinColumn(name="UserId")
	private Collection<Preference> preferences;

	/**
	 * constructor method 
	 */
	public PreferenceAlimentaire() {
		this.preferences = new HashSet<Preference>();
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
	 * @return the participant
	
	@OneToOne
	@JoinColumns(@JoinColumn(name = "idParticipant", referencedColumnName = "participant"))
	public Utilisateur getParticipant() {
		return participant;
	}
	*/
	/**
	 * @param participant
	 *            the participant to set
	
	public void setParticipant(Utilisateur participant) {
		this.participant = participant;
	}
*/
	/**
	 * @return the reunion
	 
	@OneToOne
	@JoinColumns(@JoinColumn(name = "idReunion", referencedColumnName = "reunion"))
	public Reunion getReunion() {
		return reunion;
	}
*/
	/**
	 * @param reunion
	 *            the reunion to set
	 
	public void setReunion(Reunion reunion) {
		this.reunion = reunion;
	}
*/
	/**
	 * @return the preferences
	 */
	
	public Collection<Preference> getPreferences() {
		return preferences;
	}

	/**
	 * @param preferences
	 *            the preferences to set
	 */
	public void setPreferences(Collection<Preference> preferences) {
		this.preferences = preferences;
	}

	/**
	 * @param preference
	 * 			the preference to add
	 */
	public void addPreference(Preference preference) {
		Objects.requireNonNull(preference, "Ne doit pas être vide");
		this.preferences.add(preference);
	}
	/**
	 * @param preference
	 * 			the preference to remove
	 */
	public boolean removePreference(Preference preference) {
		Objects.requireNonNull(preference, "Ne doit pas être vide");
		if(!this.preferences.contains(preference)) {
			return false;
		}
		return this.preferences.remove(preference);
	}
}
