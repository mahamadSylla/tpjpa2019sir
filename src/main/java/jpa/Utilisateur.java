/**
 * 
 */
package jpa;

import java.util.Collection;

import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author Mahamadou SYLLA
 *
 */
public class Utilisateur {
	private String mail;
	private String firstName;
	private String name;
	Collection<Reunion> reunions;
	private Role role;
	Collection<Alergies> alergies;
	
	/**
	 * @return the mail
	 */
	@Id
	public String getMail() {
		return mail;
	}
	/**
	 * @param mail the mail to set
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
	 * @param firstName the firstName to set
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
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the reunions
	 */
	@ManyToMany
	public Collection<Reunion> getReunions() {
		return reunions;
	}
	/**
	 * @param reunions the reunions to set
	 */
	public void setReunions(Collection<Reunion> reunions) {
		this.reunions = reunions;
	}
	/**
	 * @return the role
	 */
	@ManyToOne
	public Role getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}
	/**
	 * @return the alergies
	 */
	@OneToMany(mappedBy ="participant")
	public Collection<Alergies> getAlergies() {
		return alergies;
	}
	/**
	 * @param alergies the alergies to set
	 */
	public void setAlergies(Collection<Alergies> alergies) {
		this.alergies = alergies;
	}
		
}
