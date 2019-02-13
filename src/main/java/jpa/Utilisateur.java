/**
 * 
 */
package jpa;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 * @author Mahamadou SYLLA
 *
 */
@Entity
public class Utilisateur {
	private String mail;
	private String firstName;
	private String name;
	private Collection<Reunion> reunions;
	private Collection<Sondage> sondages;
	private Collection<Role> role;
	private Collection<Alergies> alergies;

	public Utilisateur() {
		this.reunions = new HashSet<Reunion>();
		this.sondages = new HashSet<Sondage>();
		this.alergies = new HashSet<Alergies>();
	}

	/**
	 * @return the mail
	 */
	@Id
	@Column(name = "idUser")
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
	 * @return the reunions
	 */
	//@ManyToMany(mappedBy = "participants")
	public Collection<Reunion> getReunions() {
		return reunions;
	}

	/**
	 * @param reunions
	 *            the reunions to set
	 */
	public void setReunions(Collection<Reunion> reunions) {
		this.reunions = reunions;
	}

	/**
	 * @return the role
	 */
	@OneToMany
	@JoinColumn(name ="idUser")
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
	//@ManyToMany
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
	 * @return the alergies
	 */
	@OneToMany(mappedBy = "idUser")
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

}
