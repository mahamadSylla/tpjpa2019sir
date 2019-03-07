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
		Objects.requireNonNull(idSondage, "ne peut pas �tre null");
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
		Objects.requireNonNull(sondage, "ne peut pas �tre null");
		EntityManagerHelper.beginTransaction();
		Utilisateur u = manager.find(Utilisateur.class, idUser);
		if (u == null) {
			return;
		}
		u.addSondage(sondage);
		this.manager.persist(u);
		EntityManagerHelper.commit();
		EntityManagerHelper.closeEntityManager();
		System.out.println("Le sondage a �t� cr�e!");

	}

	public void repondreSondage(int idUser, int idSondage, ReponseSondage reponse) {
		Objects.requireNonNull(reponse, "ne peut pas �tre null");
		Objects.requireNonNull(idUser, "ne peut pas �tre null");
		Objects.requireNonNull(idSondage, "ne peut pas �tre null");
		EntityManagerHelper.beginTransaction();
		Utilisateur u = manager.find(Utilisateur.class, idUser);
		Sondage s = manager.find(Sondage.class, idSondage);
		if (u == null || s == null) {
			return;
		}
		reponse.setSondage(s);
		u.addReponse(reponse);
		s.addReponse(reponse);
		this.manager.persist(u);
		this.manager.persist(s);
		EntityManagerHelper.commit();
		EntityManagerHelper.closeEntityManager();
		System.out.println("La r�ponse a �t� ajout�e!");

	}

	public Collection<ReponseSondage> datesProposees(int idSondage) {
		Objects.requireNonNull(idSondage, "ne peut pas �tre null");
		try {
			Sondage sondage = manager.find(Sondage.class, idSondage);
			return sondage.getReponseSondages();
		} catch (Exception e) {
		}
		return null;

	}

	public Utilisateur createurSondage(int idSondage) {
		Objects.requireNonNull(idSondage, "ne peut pas �tre null");
		try {
			Sondage sondage = manager.find(Sondage.class, idSondage);
			return sondage.getCreateur();
		} catch (Exception e) {
		}
		return null;
	}

	public void validerUneDate(int idSondage, int idChoixDate) {
		Objects.requireNonNull(idSondage, "ne peut pas �tre null");
		Objects.requireNonNull(idChoixDate, "ne peut pas �tre null");
		try {
			System.out.println("--------11111----");
			Sondage sondage = manager.find(Sondage.class, idSondage);
			ChoixDate date = manager.find(ChoixDate.class, idChoixDate);
			Reunion reunion = manager.createNamedQuery("findSurveyOfmeetingById", Reunion.class)
					.setParameter("sondageId", idSondage).getSingleResult();
			
			System.out.println("la r�union" + reunion.getIntitule());
			sondage.setDateRetenue(date);
			reunion.setDateReunion(date);
			Collection<ReponseSondage> reponses = sondage.getReponseSondages();
			System.out.println("------------");
			for (ReponseSondage r : reponses) {
				int idUser = r.getParticipant().getId();
				ajouterPresenceOuAbsence(idUser, idSondage, date, reunion);
			}
			System.out.println("_iiiii");
			EntityManagerHelper.beginTransaction();
			this.manager.persist(sondage);
			this.manager.persist(reunion);
			EntityManagerHelper.commit();
			EntityManagerHelper.closeEntityManager();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void ajouterPresenceOuAbsence(int idUser, int idSondage, ChoixDate dateRetenue, Reunion reunion) {
		Utilisateur user = manager.find(Utilisateur.class, idUser);
		ReponseSondage reponse = manager.createNamedQuery("findAnswersOfsurveyByUser", ReponseSondage.class)
				.setParameter("participantId", idUser).setParameter("sondageId", idSondage).getSingleResult();
		Collection<ChoixDate> choix = reponse.getChoixDonnes();
		if (choix.contains(dateRetenue)) {
			user.addPresence(reunion);
		} else {
			user.addAbsence(reunion);
		}
		EntityManagerHelper.beginTransaction();
		this.manager.persist(user);
		EntityManagerHelper.commit();
		EntityManagerHelper.closeEntityManager();
	}

	public void creerUnePlageHoraire(ChoixDate plageHoraire) {
		try {
			Objects.requireNonNull(plageHoraire, "ne peut pas �tre null");
			EntityManagerHelper.beginTransaction();
			this.manager.persist(plageHoraire);
			EntityManagerHelper.commit();
			EntityManagerHelper.closeEntityManager();
			System.out.println("La plage horaire a �t� cr�e!");
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void ajouterUneDate_A_UnSondage(int idSondage, int idChoixDate) {
		Objects.requireNonNull(idSondage, "ne peut pas �tre null");
		try {
			Sondage sondage = manager.find(Sondage.class, idSondage);
			ChoixDate date = manager.find(ChoixDate.class, idChoixDate);
			if (sondage == null && date == null) {
				return;
			}
			sondage.addChoix(date);
			EntityManagerHelper.beginTransaction();
			this.manager.persist(sondage);
			EntityManagerHelper.commit();
			EntityManagerHelper.closeEntityManager();
			System.out.println("La date a �t� ajout�e au sondage");

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void choisirUneDate(int idReponseSondage, int idChoixDate) {
		try {
			ReponseSondage reponse = manager.find(ReponseSondage.class, idReponseSondage);
			ChoixDate date = manager.find(ChoixDate.class, idChoixDate);
			if (reponse == null && date == null) {
				return;
			}
			reponse.addChoix(date);
			EntityManagerHelper.beginTransaction();
			this.manager.persist(reponse);
			EntityManagerHelper.commit();
			EntityManagerHelper.closeEntityManager();
			System.out.println("La date a �t� ajout�e � la r�ponse");

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
