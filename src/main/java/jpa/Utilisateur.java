/**
 * 
 */
package jpa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonManagedReference;

/**
 * @author Mahamadou SYLLA
 *
 */
@Entity
@NamedQueries({ @NamedQuery(name = "findAllUsers", query = "SELECT u FROM Utilisateur u"),
})
public class Utilisateur {
	private int id;
	private String mail;
	private String firstName;
	private String name;
	private Collection<Reunion> presences;
	private Collection<Reunion> absences;
	private Collection<Sondage> sondages;
	private Collection<Role> role;
	private Collection<Alergies> alergies;
	private Collection<ReponseSondage> reponseSondages;

	public Utilisateur() {
		this.absences = new HashSet<Reunion>();
		this.presences = new HashSet<Reunion>();
		this.sondages = new HashSet<Sondage>();
		this.alergies = new HashSet<Alergies>();
		this.reponseSondages = new ArrayList<ReponseSondage>();
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
	 * @return the mail
	 */
	@Column(nullable = false, unique = true)
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail
	 *            the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
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
	 * @return the role
	 */
	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "utilisateur_id")
	public Collection<Role> getRole() {
		return role;
	}

	/**
	 * @param role
	 *            the role to set
	 */
	public void setRole(Collection<Role> role) {
		this.role = role;
	}

	/**
	 * @return the sondages
	 */
	@OneToMany(mappedBy = "createur", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JsonManagedReference(value = "utilisateur_sondage")
	public Collection<Sondage> getSondages() {
		return sondages;
	}

	/**
	 * @param sondages
	 *            the sondages to set
	 */

	public void setSondages(Collection<Sondage> sondages) {
		this.sondages = sondages;
	}

	/**
	 * @return the presences
	 */
	@ManyToMany 
	@JoinTable(name="les_presences",
		        joinColumns = @JoinColumn (name="utilisateur_id"),
		        inverseJoinColumns = @JoinColumn (name="reunion_id")
	)
	@JsonManagedReference(value = "utilisateur_present")
	@JsonIgnore
	public Collection<Reunion> getPresences() {
		return presences;
	}

	/**
	 * @param reunions
	 *            the presence to set
	 */
	public void setPresences(Collection<Reunion> presences) {
		this.presences = presences;
	}

	/**
	 * @return the absences
	*/
	@ManyToMany
	@JoinTable(name = "les_absences",
			joinColumns = @JoinColumn (name="utilisateur_id"),
	        inverseJoinColumns = @JoinColumn (name="reunion_id")
	)
	@JsonManagedReference(value = "utilisateur_absent")
	@JsonIgnore
	public Collection<Reunion> getAbsences() {
		return absences;
	} 

	/**
	 * @param reunions
	 *            the absences to set
	 */
	public void setAbsences(Collection<Reunion> absences) {
		this.absences = absences;
	}

	
	/**
	 * @return the reponseSondages
	 */
	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "participant")
	@JsonManagedReference(value = "utilisateur_reponse")
	public Collection<ReponseSondage> getReponseSondages() {
		return reponseSondages;
	}

	/**
	 * @param reponseSondages
	 *            the reponseSondages to set
	 */
	public void setReponseSondages(Collection<ReponseSondage> reponseSondages) {
		this.reponseSondages = reponseSondages;
	}

	/**
	 * @return the alergies
	 */
	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "idUser")
	public Collection<Alergies> getAlergies() {
		return alergies;
	}

	/**
	 * @param alergies
	 *            the alergies to set
	 */
	public void setAlergies(Collection<Alergies> alergies) {
		this.alergies = alergies;
	}

	/**
	 * @param role
	 *            the role to add
	 */
	public void addRole(Role role) {
		Objects.requireNonNull(role, "Le role ne doit pas ï¿½tre null");
		this.role.add(role);
	}

	/**
	 * @param reunion
	 *            the reunion to add
	 */
	public void addPresence(Reunion reunion) {
		Objects.requireNonNull(reunion, "La reunion ne doit pas être null");
		this.presences.add(reunion);
	}
	/**
	 * @param reunion
	 *            the reunion to add
	 */
	public void addAbsence(Reunion reunion) {
		Objects.requireNonNull(reunion, "La reunion ne doit pas être null");
		this.absences.add(reunion);
	}

	/**
	 * @param reunion
	 *            the sondage to add
	 */
	public void addSondage(Sondage sondage) {
		Objects.requireNonNull(sondage, "Le sondage ne doit pas être null");
		this.sondages.add(sondage);
	}

	/**
	 * @param alergie
	 *            the alergie to add
	 */
	public void addAlergie(Alergies alergie) {
		Objects.requireNonNull(alergie, "Ne doit pas être nul");
		this.alergies.add(alergie);
	}

	/**
	 * @param alergie
	 *            the alergie to remove
	 */
	public boolean removeAlergie(Alergies alergie) {
		Objects.requireNonNull(alergie, "Ne doit pas être nul");
		return this.alergies.remove(alergie);
	}

	/**
	 * @param reponse
	 *            the reponse to add
	 */
	public void addReponse(ReponseSondage reponse) {
		Objects.requireNonNull(reponse, "Ne doit pas être nul");
		this.reponseSondages.add(reponse);
	}
	
	/**
	 * @param preference
	 *            the preference to add
	 
	public void addPreference(Preference preference) {
		Objects.requireNonNull(preference, "Ne doit pas être nul");
		this.preferences.add(preference);
	}
*/
	/**
	 * @param preference
	 *            the preference to remove
	 
	public boolean removePreference(Preference preference) {
		Objects.requireNonNull(preference, "Ne doit pas être nul");
		if (!this.preferences.contains(preference)) {

			return false;
		}
		return this.preferences.remove(preference);
	}*/
}
