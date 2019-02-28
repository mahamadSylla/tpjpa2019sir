package jpa;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;

@Entity
public class Sondage {
	private int id;
	private String intitule;
	private String participatedWebLink;
	//private String chooseFoodWebLink;
	private Collection<ChoixDate> dates;
	//private Reunion reunion;
	private Utilisateur createur;
	private Collection<ReponseSondage> reponseSondages;

	public Sondage() {
		this.reponseSondages = new HashSet<ReponseSondage>();
	}

	/**
	 * @return the reponseSondages
	 */
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy="sondage")
	@JsonBackReference(value="sondage_reponse")
	public Collection<ReponseSondage> getReponseSondages() {
		return reponseSondages;
	}

	/**
	 * @param reponseSondages the reponseSondages to set
	*/
	public void setReponseSondages(Collection<ReponseSondage> reponseSondages) {
		this.reponseSondages = reponseSondages;
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
	 * @return the chooseFoodWebLink
	 
	public String getChooseFoodWebLink() {
		return chooseFoodWebLink;
	}
*/
	/**
	 * @param chooseFoodWebLink
	 *            the chooseFoodWebLink to set
	 
	public void setChooseFoodWebLink(String chooseFoodWebLink) {
		this.chooseFoodWebLink = chooseFoodWebLink;
	}
*/
	
	/**
	 * @return the participatedWebLink
	*/ 
	public String getParticipatedWebLink() {
		return participatedWebLink;
	}

	/**
	 * @param participatedWebLink
	 *            the participatedWebLink to set
	*/ 
	public void setParticipatedWebLink(String participatedWebLink) {
		this.participatedWebLink = participatedWebLink;
	}

	/**
	 * @return the dates
	 */
	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name="sondage_id")
	public Collection<ChoixDate> getDates() {
		return dates;
	}

	/**
	 * @param dates
	 *            the dates to set
	 */
	public void setDates(Collection<ChoixDate> dates) {
		this.dates = dates;
	}

	/**
	 * @return the reunion
	 
	@OneToOne
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
	 * @return the createur
	 */
	@ManyToOne
	@JsonManagedReference(value="utilisateur_sondage")
	public Utilisateur getCreateur() {
		return createur;
	}

	/**
	 * @param createur
	 *            the createur to set
	 */
	public void setCreateur(Utilisateur createur) {
		this.createur = createur;
	}
	
	/**
	 * @param date
	 * 			the date to add
	 */
	public void addChoix(ChoixDate date) {
		Objects.requireNonNull(date, "La date ne doit pas �tre nulle");
		this.dates.add(date);
	}
	
	/**
	 * @param date
	 * 			the date to remove
	 */
	public boolean removeChoix(ChoixDate date) {
		Objects.requireNonNull(date, "Ne doit pas �tre vide");
		if(!this.dates.contains(date)) {
			return false;
		}
		return this.dates.remove(date);
	}
}
