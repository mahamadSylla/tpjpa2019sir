package daoImpl;

import java.sql.Date;
import java.util.Collection;

import javax.persistence.EntityManager;

import daoInterfaces.SondageDAO;
import jpa.EntityManagerHelper;
import jpa.Sondage;
import jpa.Utilisateur;

public class SondageDaoImpl implements SondageDAO {
	private EntityManager manager;
	public SondageDaoImpl() {
	}
	public void sondage() {
		// TODO Auto-generated method stub
		
	}
	public void listSondage() {
		// TODO Auto-generated method stub
		
	}
	public void creerSondage(Sondage sondage) {
		EntityManagerHelper.beginTransaction();
		this.manager.persist(sondage);
		EntityManagerHelper.commit();
		EntityManagerHelper.closeEntityManager();
		System.out.println("Le sondage a été crée!");
		
	}
	public void dateRetenue(Sondage sondage) {
		// TODO Auto-generated method stub
		
	}
	public void datesProposees(Sondage sondage) {
		// TODO Auto-generated method stub
		
	}
	public void createurSondage(Sondage sondage) {
		// TODO Auto-generated method stub
		
	}
	public void validerUneDate(Date date) {
		// TODO Auto-generated method stub
		
	}
	

}
