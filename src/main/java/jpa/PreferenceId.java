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
public class PreferenceId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "idParticipant")
	private int idParticipant;

	@Column(name = "idReunion")
	private int idReunion;

	/**
	 * construtor method
	 */
	public PreferenceId() {
	}

	/**
	 * @param participantId
	 * @param reunionId
	 */
	public PreferenceId(int idParticipant, int idReunion) {
		this.idParticipant = idParticipant;
		this.idReunion = idReunion;
	}

	/**
	 * @return the participantId
	 */
	public int getParticipantId() {
		return idParticipant;
	}

	/**
	 * @param idParticipant
	 *            the participant to set
	 */
	public void setParticipantId(int idParticipant) {
		this.idParticipant = idParticipant;
	}

	/**
	 * @return the reunion
	 */
	public int getReunionId() {
		return idReunion;
	}

	/**
	 * @param reunionId
	 *            the reunionId to set
	 */
	public void setReunionId(int reunionId) {
		this.idReunion = reunionId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof PreferenceId))
			return false;
		PreferenceId that = (PreferenceId) o;
		return Objects.equals(getParticipantId(), that.getParticipantId())
				&& Objects.equals(getReunionId(), that.getReunionId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getParticipantId(), getReunionId());
	}

}
