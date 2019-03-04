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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;

@Entity
@NamedQueries({ @NamedQuery(name = "findAllSurvey", query = "SELECT s FROM Sondage s"),
})
public class Sondage {
	private int id;
	private String intitule;
	private String participatedWebLink;
	//private String chooseFoodWebLink;
	private Collection<ChoixDate> dates;
	private ChoixDate dateRetenue;
	private Utilisateur createur;
	private Collection<ReponseSondage> reponseSondages;

	public Sondage() {
		this.reponseSondages = new HashSet<ReponseSondage>();
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
	@OneToOne
	public ChoixDate getDateRetenue() {
		return dateRetenue;
	}

	public void setDateRetenue(ChoixDate dateRetenue) {
		this.dateRetenue = dateRetenue;
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
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
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
	 * @return the reponseSondages
	 */
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy="sondage")
	@JsonManagedReference(value="sondage_reponse")
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
	 * @return the createur
	 */
	@ManyToOne
	@JsonBackReference(value="utilisateur_sondage")
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
		Objects.requireNonNull(date, "La date ne doit pas être nulle");
		this.dates.add(date);
	}
	
	/**
	 * @param date
	 * 			the date to remove
	 */
	public boolean removeChoix(ChoixDate date) {
		Objects.requireNonNull(date, "Ne doit pas être vide");
		if(!this.dates.contains(date)) {
			return false;
		}
		return this.dates.remove(date);
	}
	/**
	 * @param reponse
	 *            the reponse to add
	 */
	public void addReponse(ReponseSondage reponse) {
		Objects.requireNonNull(reponse, "Ne doit pas être nul");
		this.reponseSondages.add(reponse);
	}

}
