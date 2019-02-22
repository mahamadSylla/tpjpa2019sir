/**
 * 
 */
package jpa;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
	private Collection<Preference> preferences;

	public Reunion() {
		this.participants = new HashSet<Utilisateur>();
		this.preferences = new HashSet<Preference>();
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
	@OneToOne
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
	 * @return the participants
	 */
	@ManyToMany
	//@JoinTable(name = "userReunions", joinColumns = @JoinColumn(name = "idReunion"), inverseJoinColumns = @JoinColumn(name = "idParticipant"))
	public Collection<Utilisateur> getParticipants() {
		return participants;
	}

	/**
	 * @param participant
	 *            the participant to set
	 */
	public void setParticipants(Collection<Utilisateur> participant) {
		this.participants = participant;
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
	

	/**
	 * @return the preferences
	 */
	@OneToMany(cascade=CascadeType.PERSIST)
	@JoinColumn(name="reunionId")
	public Collection<Preference> getPreferences() {
		return preferences;
	}

	/**
	 * @param preferences the preferences to set
	 */
	public void setPreferences(Collection<Preference> preferences) {
		this.preferences = preferences;
	}

	/**
	 * @param user
	 *            the user to add
	 */
	public void addParticipant(Utilisateur user) {
		Objects.requireNonNull(user, "L'utilisateur ne doit pas être nul");
		this.participants.add(user);
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
