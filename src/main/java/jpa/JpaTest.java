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
		// EntityManagerFactory factory =
		// Persistence.createEntityManagerFactory("tpjpa");
		EntityManager manager = EntityManagerHelper.getEntityManager();
		JpaTest test = new JpaTest(manager);
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		try {
			
			//test.createEmployees();
			UtilisateurServiceImpl userServ = new UtilisateurServiceImpl();
			Role myRole = new Role();
			Collection<Role> r = new ArrayList<Role>();
			r.add(myRole);
			myRole.setName("createur");
			Utilisateur ut1 = new Utilisateur();
			ut1.setName("Sylla");
			ut1.setFirstName("Mahamadou");
			ut1.setMail("mahamadsylla5@gmail.com");
			ut1.setRole(r);
			userServ.createUtilisateur(ut1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

		manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		// factory.close();
	}

	/*private void createEmployees() {
		int numOfEmployees = manager.createQuery("Select a From Employee a", Employee.class).getResultList().size();
		if (numOfEmployees == 0) {
			Department department = new Department("java");
			manager.persist(department);

			manager.persist(new Employee("Jakab Gipsz", department));
			manager.persist(new Employee("Captain Nemo", department));

		}
	}

	private void listEmployees() {
		List<Employee> resultList = manager.createQuery("Select a From Employee a", Employee.class).getResultList();
		System.out.println("num of employess:" + resultList.size());
		for (Employee next : resultList) {
			System.out.println("next employee: " + next);
		}
	}*/

}
