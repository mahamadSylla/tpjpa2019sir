package daoImpl;

import java.util.Collection;
import java.util.Objects;

import javax.persistence.EntityManager;
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

	public Collection<Sondage> listSondage() {
		return this.manager.createNamedQuery("findAllSurvey", Sondage.class).getResultList();
	}

	public void creerSondage(int idUser, Sondage sondage) {
		Objects.requireNonNull(sondage, "ne peut pas être null");
		EntityManagerHelper.beginTransaction();
		Utilisateur u = manager.find(Utilisateur.class, idUser);
		if(u == null) {return ;}
		u.addSondage(sondage);
		this.manager.persist(u);
		EntityManagerHelper.commit();
		EntityManagerHelper.closeEntityManager();
		System.out.println("Le sondage a été crée!");
		
	}
	
	public void repondreSondage(int idUser, int idSondage, ReponseSondage reponse) {
		Objects.requireNonNull(reponse, "ne peut pas être null");
		Objects.requireNonNull(idUser, "ne peut pas être null");
		Objects.requireNonNull(idSondage, "ne peut pas être null");
		EntityManagerHelper.beginTransaction();
		Utilisateur u = manager.find(Utilisateur.class, idUser);
		Sondage  s = manager.find(Sondage.class, idSondage);
		if(u == null || s == null) {return;}
		reponse.setSondage(s);
		u.addReponse(reponse);
		s.addReponse(reponse);
		this.manager.persist(u);
		this.manager.persist(s);
		EntityManagerHelper.commit();
		EntityManagerHelper.closeEntityManager();
		System.out.println("La réponse a été ajoutée!");
		
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

	public void validerUneDate(int idSondage, int idChoixDate) {
		Objects.requireNonNull(idSondage, "ne peut pas être null");
		Objects.requireNonNull(idChoixDate, "ne peut pas être null");
		try {
			Sondage sondage = manager.find(Sondage.class, idSondage);
			ChoixDate date = manager.find(ChoixDate.class, idChoixDate);
			Reunion reunion = manager.createNamedQuery("findSurveyOfmeetingById", Reunion.class)
					.setParameter("sondageId", idSondage).getSingleResult();
			sondage.setDateRetenue(date);
			reunion.setDateReunion(date);
			EntityManagerHelper.beginTransaction();
			this.manager.persist(sondage);
			this.manager.persist(reunion);
			EntityManagerHelper.commit();
			EntityManagerHelper.closeEntityManager();
		} catch (Exception e) {
		}
	}

}
