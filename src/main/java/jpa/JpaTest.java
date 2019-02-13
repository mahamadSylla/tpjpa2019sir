package jpa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import daoImpl.UtilisateurDaoImpl;
import servicesImpl.UtilisateurServiceImpl;

public class JpaTest {

	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
		EntityManager manager = factory.createEntityManager();
		JpaTest test = new JpaTest(manager);
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		try {
			UtilisateurServiceImpl userServ = new UtilisateurServiceImpl();

			Collection<Role> roles = new ArrayList<Role>();
			Role r1 = new Role();
			Role r2 = new Role();
			r1.setName("createur");
			r2.setName("participant");
			roles.add(r1);
			roles.add(r2);

			Utilisateur ut1 = new Utilisateur();
			ut1.setName("Sylla");
			ut1.setFirstName("Mahamadou");
			ut1.setMail("mahamadsylla5@gmail.com");
			ut1.setRole(roles);
			userServ.createUtilisateur(ut1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

		manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		// factory.close();
	}

}
