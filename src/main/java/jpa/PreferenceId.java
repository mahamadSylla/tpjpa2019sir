/**
 * 
 */
package jpa;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Mahamadou SYLLA
 *
 */
//@Embeddable
public class PreferenceId implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "idParticipant")
	private Utilisateur participant;
	
	@Column(name = "idReunion")
	private Reunion reunion;

	/**
	 * construtor method
	 */
	public PreferenceId() {
	}

	/**
	 * @param participant
	 * @param reunion
	 */
	public PreferenceId(Utilisateur participant, Reunion reunion) {
		super();
		this.participant = participant;
		this.reunion = reunion;
	}

	/**
	 * @return the participant
	 */
	public Utilisateur getParticipant() {
		return participant;
	}

	/**
	 * @param participant the participant to set
	 */
	public void setParticipant(Utilisateur participant) {
		this.participant = participant;
	}

	/**
	 * @return the reunion
	 */
	public Reunion getReunion() {
		return reunion;
	}

	/**
	 * @param reunion the reunion to set
	 */
	public void setReunion(Reunion reunion) {
		this.reunion = reunion;
	}
	
	@Override
	public boolean equals( Object o) {
		if (this == o) return true;
        if (!(o instanceof PreferenceId)) return false;
        PreferenceId that = (PreferenceId) o;
        return Objects.equals(getParticipant(), that.getParticipant()) &&
                Objects.equals(getReunion(), that.getReunion());
	}
	
	@Override
    public int hashCode() {
        return Objects.hash(getParticipant(), getReunion());
    }

}
