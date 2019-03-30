/**
 * 
 */
package jpa;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import org.codehaus.jackson.annotate.JsonBackReference;

/**
 * @author Mahamadou SYLLA
 * @author Linda YAO
 *
 */
@Entity
@NamedQueries({ 
	@NamedQuery(name = "findAllMeeting", query = "SELECT r FROM Reunion r"),
	@NamedQuery(name = "finMeetingByIdSondage", query = "SELECT r FROM Reunion r WHERE r.sondage.id = :idSondage")
})

public class Reunion {
	private int id;
	private String intitule;
	private String resume;
	private ChoixDate dateReunion;
	private Sondage sondage;
	private Collection<Utilisateur> presents;
	private Collection<Utilisateur> absents;
	//private Collection<Preference> preferences;

	public Reunion() {
		this.presents = new HashSet<Utilisateur>();
		//this.preferences = new HashSet<Preference>();
		this.absents = new HashSet<Utilisateur>();
	}

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
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
	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(unique=true)
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
	 * @return the presents
	 */
	@ManyToMany(mappedBy="presences")
	@JsonBackReference(value="utilisateur_present")
	public Collection<Utilisateur> getPresents() {
		return presents;
	}

	/**
	 * @param presents
	 *            the presents to set
	 */
	public void setPresents(Collection<Utilisateur> presents) {
		this.presents = presents;
	}

	/**
	 * @return the absents
	*/
	@ManyToMany(mappedBy="absences")
	@JsonBackReference(value="utilisateur_absent")
	public Collection<Utilisateur> getAbsents() {
		return absents;
	}

	/**
	 * @param absents the absents to set
	 */
	public void setAbsents(Collection<Utilisateur> absents) {
		this.absents = absents;
	}
	
	/**
	 * @return the sondage
	 */
	@OneToOne
	@JoinColumn(unique=true)
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
	 
	@OneToMany(cascade=CascadeType.PERSIST)
	@JoinColumn(name="reunionId")
	public Collection<Preference> getPreferences() {
		return preferences;
	}
*/
	/**
	 * @param preferences the preferences to set
	
	public void setPreferences(Collection<Preference> preferences) {
		this.preferences = preferences;
	}
*/
	/**
	 * @param user
	 *            the user to add
	 */
	public void addParticipant(Utilisateur user) {
		Objects.requireNonNull(user, "L'utilisateur ne doit pas être nul");
		this.presents.add(user);
	}
	
	/**
	 * @param preference
	 * 			the preference to add

	public void addPreference(Preference preference) {
		Objects.requireNonNull(preference, "Ne doit pas être vide");
		this.preferences.add(preference);
	}*/
	/**
	 * @param preference
	 * 			the preference to remove
	 
	public boolean removePreference(Preference preference) {
		Objects.requireNonNull(preference, "Ne doit pas être vide");
		if(!this.preferences.contains(preference)) {
			return false;
		}
		return this.preferences.remove(preference);
	}*/
	
	public void participation(int idSondage) {
		Objects.requireNonNull(idSondage, "ne dois pas être nul");
		
	}


}
