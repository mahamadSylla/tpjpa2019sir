package jpa;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import daoImpl.UtilisateurDaoImpl;
import servicesImpl.SondageServiceImpl;
import servicesImpl.UtilisateurServiceImpl;

public class JpaTest {

	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
		EntityManager manager = factory.createEntityManager();
		JpaTest test = new JpaTest(manager);
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		try {
			//Cr�ation d'un utilisateur et ses r�les et alergies
			/*UtilisateurServiceImpl userServ = new UtilisateurServiceImpl();
			Collection<Role> roles = new ArrayList<Role>();
			Role r1 = new Role();
			Role r2 = new Role();
			r1.setName("createur");
			r2.setName("role2");
			roles.add(r1);
			roles.add(r2);

			Utilisateur ut1 = new Utilisateur();
			ut1.setName("Sylla");
			ut1.setFirstName("Mahamadou");
			ut1.setMail("mahamadsla5@gmail.com3");
			ut1.setRole(roles);
		

			Collection<Alergies> alergies = new ArrayList<Alergies>();
			Alergies alergie = new Alergies();
			alergie.setName("sucre");
			alergies.add(alergie);
			
			ut1.setAlergies(alergies);*/
			//userServ.createUtilisateur(ut1);
			
			/*
			//Cr�ation des plages horaires pour le sondage
			Date date1 = new Date(2019,2,15);
			Date date2 = new Date(2019,2,15);
			Date date3 = new Date(2019,2,18);
			
			ChoixDate plage1 = new ChoixDate();
			plage1.setDebut(10);
			plage1.setFin(12);
			plage1.setMyDate(date1);

			ChoixDate plage2 = new ChoixDate();
			plage2.setDebut(10);
			plage2.setFin(12);
			plage2.setMyDate(date2);
			
			ChoixDate plage3 = new ChoixDate();
			plage3.setDebut(10);
			plage3.setFin(12);
			plage3.setMyDate(date3);
			Collection<ChoixDate> dates = new ArrayList<ChoixDate>();
			dates.add(plage1);
			dates.add(plage2);
			dates.add(plage3);
			
			//Cr�ation d'un sondage
			SondageServiceImpl sondageImp = new SondageServiceImpl();
			Sondage sondage = new Sondage();
			sondage.setCreateur(ut1);
			sondage.setIntitule("Test");
			sondage.setParticipatedWebLink("lien.php");
			sondage.setDates(dates);
			sondageImp.createSondage(sondage);*/
			
			/*Utilisateur user = manager.find(Utilisateur.class, 1L);
			for(Sondage s : user.getSondages()) {
				System.out.println("Intul�" + s.getIntitule());
			}
			Preference pref = new Preference();
			pref.setName("Soumbala");
			user.addRole(r2);*/
			//userServ.createUtilisateur(user);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

		manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		// factory.close();
	}
}
