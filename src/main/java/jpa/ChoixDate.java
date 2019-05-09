package jpa;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.codehaus.jackson.map.annotate.JsonDeserialize;

@Entity
@NamedQueries({
	@NamedQuery(name = "findAllChoixDate", query = "SELECT c FROM ChoixDate c")
})
public class ChoixDate {

	private int id;
	private Date myDate;
	private int debut;
	private int fin;

	public ChoixDate() {
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
	 * @return the debut
	 */
	public int getDebut() {
		return debut;
	}

	/**
	 * @param debut
	 *            the debut to set
	 */
	public void setDebut(int debut) {
		this.debut = debut;
	}

	/**
	 * @return the fin
	 */
	public int getFin() {
		return fin;
	}

	/**
	 * @param fin
	 *            the fin to set
	 */
	public void setFin(int fin) {
		this.fin = fin;
	}

	/**
	 * @return the myDate
	 */
	@JsonDeserialize(using=CustomDateDeserializer.class)
	public Date getMyDate() {
		return myDate;
	}
	
	/**
	 * @param myDate
	 *            the myDate to set
	 */
	public void setMyDate(Date myDate) {
		this.myDate = myDate;
	}
}
