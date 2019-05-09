package jpa;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.codehaus.jackson.annotate.JsonBackReference;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "findAnswersOfsurveyByUser", query = "SELECT r FROM ReponseSondage r WHERE r.participant.id = :participantId AND r.sondage.id = :sondageId")
	})

public class ReponseSondage {
	private int id;
	private Utilisateur participant;
	private Sondage sondage;
	private Collection<ChoixDate> choixDonnes;

	public ReponseSondage() {
		this.choixDonnes = new HashSet<ChoixDate>();
	}

	/**
	 * 
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
	 * @return the participant
	 */
	@ManyToOne
	@JsonBackReference(value = "utilisateur_reponse")
	public Utilisateur getParticipant() {
		return participant;
	}

	/**
	 * @param participant
	 *            the participant to set
	 */
	public void setParticipant(Utilisateur utilisateur) {
		this.participant = utilisateur;
	}

	/**
	 * @return the sondage
	 */
	@ManyToOne
	@JoinColumn(name = "sondage_id")
	@JsonBackReference(value = "sondage_reponse")
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
	 * @return the choixDonnes
	 */
	@OneToMany
	@JoinColumn(name = "reponse_id")
	public Collection<ChoixDate> getChoixDonnes() {
		return choixDonnes;
	}

	/**
	 * @param choixDonnes
	 *            the choixDonnes to set
	 */
	public void setChoixDonnes(Collection<ChoixDate> choixDonnes) {
		this.choixDonnes = choixDonnes;
	}

	/**
	 * @param date
	 *            the date to add
	 */
	public void addChoix(ChoixDate date) {
		Objects.requireNonNull(date, "La date ne doit pas être nulle");
		this.choixDonnes.add(date);
	}

	/**
	 * @param date
	 *            the date to remove
	 */
	public boolean removeChoix(ChoixDate date) {
		Objects.requireNonNull(date, "Ne doit pas être nulle");
		if (!this.choixDonnes.contains(date)) {
			return false;
		}
		return this.choixDonnes.remove(date);
	}
}
