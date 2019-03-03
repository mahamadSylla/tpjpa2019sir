package daoImpl;

import java.util.Collection;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import daoInterfaces.ReunionDAO;
import jpa.EntityManagerHelper;
import jpa.Reunion;
import jpa.Sondage;
import jpa.Utilisateur;

public class ReunionDaoImpl implements ReunionDAO{
	EntityManager manager;
	/**
	 * 
	 */
	public ReunionDaoImpl() {
		this.manager = EntityManagerHelper.getEntityManager();
	}

	public Reunion reunion(int idReunion) {
		Objects.requireNonNull(idReunion, "ne peut pas être null");
		try {
			Reunion reunion = manager.find(Reunion.class, idReunion);
			return reunion;
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	public Sondage sondage(int idReunion) {
		Objects.requireNonNull(idReunion, "ne peut pas être null");
		try {
			Reunion reunion = manager.find(Reunion.class, idReunion);
			return reunion.getSondage();
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public Collection<Reunion> listReunion() {
		try {
			String query = "SELECT r FROM reunon r";
			Query q = manager.createQuery(query);
			return q.getResultList();

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public void creerReunion(Reunion reunion) {
		EntityManagerHelper.beginTransaction();
		this.manager.persist(reunion);
		EntityManagerHelper.commit();
		EntityManagerHelper.closeEntityManager();
		System.out.println("La reunion a été créée!");
		
	}

	public Collection<Utilisateur> presents(int idReunion) {
		Objects.requireNonNull(idReunion, "ne peut pas être null");
		try {
			Reunion reunion = manager.find(Reunion.class, idReunion);
			return reunion.getPresents();
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	public Collection<Utilisateur> absents(int idReunion) {
		Objects.requireNonNull(idReunion, "ne peut pas être null");
		try {
			Reunion reunion = manager.find(Reunion.class, idReunion);
			return reunion.getAbsents();
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}
	
}
