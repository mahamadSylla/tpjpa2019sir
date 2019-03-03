package daoImpl;

import java.util.Collection;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import daoInterfaces.SondageDAO;
import jpa.ChoixDate;
import jpa.EntityManagerHelper;
import jpa.ReponseSondage;
import jpa.Reunion;
import jpa.Sondage;
import jpa.Utilisateur;

public class SondageDaoImpl implements SondageDAO {
	private EntityManager manager;

	public SondageDaoImpl() {
		this.manager = EntityManagerHelper.getEntityManager();
	}

	public Sondage sondage(int idSondage) {
		Objects.requireNonNull(idSondage, "ne peut pas être null");
		try {
			Sondage sondage = manager.find(Sondage.class, idSondage);
			return sondage;
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public Collection<Sondage> listSondage() {
		try {
			String query = "SELECT s FROM sonagde s";
			Query q = manager.createQuery(query);
			return q.getResultList();

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public void creerSondage(int idUser, Sondage sondage) {
		EntityManagerHelper.beginTransaction();
		Utilisateur u = manager.find(Utilisateur.class, idUser);
		if(u == null) {return ;}
		u.addSondage(sondage);
		this.manager.persist(u);
		EntityManagerHelper.commit();
		EntityManagerHelper.closeEntityManager();
		System.out.println("Le sondage a été crée!");
		

	}

	public Collection<ReponseSondage> datesProposees(int idSondage) {
		Objects.requireNonNull(idSondage, "ne peut pas être null");
		try {
			Sondage sondage = manager.find(Sondage.class, idSondage);
			return sondage.getReponseSondages();
		} catch (Exception e) {
		}
		return null;

	}

	public Utilisateur createurSondage(int idSondage) {
		Objects.requireNonNull(idSondage, "ne peut pas être null");
		try {
			Sondage sondage = manager.find(Sondage.class, idSondage);
			return sondage.getCreateur();
		} catch (Exception e) {
		}
		return null;
	}

	public void validerUneDate(int idSondage, ChoixDate date) {
		Objects.requireNonNull(idSondage, "ne peut pas être null");
		Objects.requireNonNull(date, "ne peut pas être null");
		try {
			Sondage sondage = manager.find(Sondage.class, idSondage);
			Reunion reunion = (Reunion) manager.createNamedQuery("findSurveyOfmeetingById")
					.setParameter("sondageId", idSondage).getSingleResult();
			sondage.setDateRetenue(date);
			reunion.setDateReunion(date);
		} catch (Exception e) {
		}
	}

}
