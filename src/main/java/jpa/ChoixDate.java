package jpa;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ChoixDate {

	private long id;
	private Date myDate;
	private int debut;
	private int fin;
	//private Sondage sondage;

	public ChoixDate() {
	}

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
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

	/**
	 * @return the sondage
	 
	@ManyToOne
	public Sondage getSondage() {
		return sondage;
	}
*/
	/**
	 * @param sondage
	 *            the sondage to set
	 
	public void setSondage(Sondage sondage) {
		this.sondage = sondage;
	}
*/
}
