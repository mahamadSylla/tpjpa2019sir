package jpa;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ChoixDate {
	
	private long id;
	private Date myDate;
	private Sondage sondage;
	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	/**
	 * @return the myDate
	 */
	public Date getMyDate() {
		return myDate;
	}
	/**
	 * @param myDate the myDate to set
	 */
	public void setMyDate(Date myDate) {
		this.myDate = myDate;
	}
	/**
	 * @return the sondage
	 */
	@ManyToOne
	public Sondage getSondage() {
		return sondage;
	}
	/**
	 * @param sondage the sondage to set
	 */
	public void setSondage(Sondage sondage) {
		this.sondage = sondage;
	} 
	

}
