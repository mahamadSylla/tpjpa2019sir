package daoImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

import javax.persistence.EntityManager;
import daoInterfaces.SondageDAO;
import jpa.ChoixDate;
import jpa.EntityManagerHelper;
import jpa.MailSender;
import jpa.Reponse;
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
			System.out.println(e.getMessage());
		}
		return null;
	}

	public Collection<Sondage> listSondage() {
		return this.manager.createNamedQuery("findAllSurvey", Sondage.class).getResultList();
	}

	public Sondage creerSondage(int idUser, Sondage sondage) {
		Objects.requireNonNull(sondage, "ne peut pas �tre null");
		EntityManagerHelper.beginTransaction();
		Utilisateur u = manager.find(Utilisateur.class, idUser);
		if (u == null) {
			return null;
		}
		u.addSondage(sondage);
		this.manager.persist(u);
		EntityManagerHelper.commit();
		EntityManagerHelper.closeEntityManager();
		System.out.println("Le sondage a �t� cr�e!");
		return sondage;

	}

	public Collection<ReponseSondage> reponses(int idSondage) {
		Objects.requireNonNull(idSondage, "ne peut pas �tre null");
		try {
			Sondage sondage = manager.find(Sondage.class, idSondage);
			return sondage.getReponseSondages();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;

	}

	public Utilisateur createurSondage(int idSondage) {
		Objects.requireNonNull(idSondage, "ne peut pas �tre null");
		try {
			Sondage sondage = manager.find(Sondage.class, idSondage);
			return sondage.getCreateur();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public Sondage validerUneDate(int idSondage, int idChoixDate) {
		Objects.requireNonNull(idSondage, "ne peut pas �tre null");
		Objects.requireNonNull(idChoixDate, "ne peut pas �tre null");
		try {
			Sondage sondage = manager.find(Sondage.class, idSondage);
			ChoixDate date = manager.find(ChoixDate.class, idChoixDate);
			Reunion reunion = manager.createNamedQuery("findSurveyOfmeetingById", Reunion.class)
					.setParameter("sondageId", idSondage).getSingleResult();
			sondage.setDateRetenue(date);
			reunion.setDateReunion(date);
			Collection<ReponseSondage> reponses = sondage.getReponseSondages();
			EntityManagerHelper.beginTransaction();
			for (ReponseSondage r : reponses) {
				int idUser = r.getParticipant().getId();
				ajouterPresenceOuAbsence(idUser, idSondage, date, reunion);
			}
			this.manager.persist(sondage);
			this.manager.persist(reunion);
			EntityManagerHelper.commit();
			EntityManagerHelper.closeEntityManager();
			return sondage;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	private void ajouterPresenceOuAbsence(int idUser, int idSondage, ChoixDate dateRetenue, Reunion reunion) {
		Utilisateur user = manager.find(Utilisateur.class, idUser);
		ReponseSondage reponse = manager.createNamedQuery("findAnswersOfsurveyByUser", ReponseSondage.class)
				.setParameter("participantId", idUser).setParameter("sondageId", idSondage).getSingleResult();
		Collection<ChoixDate> choix = reponse.getChoixDonnes();
		int idChoixDate = dateRetenue.getId();
		if (choix.contains(dateRetenue)) {
			if (isPause(idChoixDate)) {
				MailSender mailsender = new MailSender();
				mailsender.sendMail(user.getMail(), "Dooble");
			}
			user.addPresence(reunion);
		} else {
			user.addAbsence(reunion);
		}
		this.manager.persist(user);
	}

	private boolean isPause(int idChoixDate) {
		Objects.requireNonNull(idChoixDate, "ne peut pas �tre null");
		try {
			ChoixDate date = manager.find(ChoixDate.class, idChoixDate);
			if (date.getDebut() >= 12 && date.getDebut() <= 14) {
				return true;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public ChoixDate creerUnePlageHoraire(ChoixDate plageHoraire) {
		try {
			Objects.requireNonNull(plageHoraire, "ne peut pas �tre null");
			EntityManagerHelper.beginTransaction();
			this.manager.persist(plageHoraire);
			EntityManagerHelper.commit();
			EntityManagerHelper.closeEntityManager();
			System.out.println("La plage horaire a �t� cr��e!");
			return plageHoraire;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public ChoixDate ajouterUneDate_A_UnSondage(int idSondage, int idChoixDate) {
		Objects.requireNonNull(idSondage, "ne peut pas �tre null");
		try {
			Sondage sondage = manager.find(Sondage.class, idSondage);
			ChoixDate date = manager.find(ChoixDate.class, idChoixDate);
			if (sondage == null && date == null) {
				return null;
			}
			sondage.addChoix(date);
			EntityManagerHelper.beginTransaction();
			this.manager.persist(sondage);
			EntityManagerHelper.commit();
			EntityManagerHelper.closeEntityManager();
			System.out.println("La date a �t� ajout�e au sondage");
			return date;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public ReponseSondage repondreSondage(ReponseSondage reponse) {
		Objects.requireNonNull(reponse, "ne peut pas �tre null");
		Utilisateur u = reponse.getParticipant();
		Sondage s = reponse.getSondage();
		EntityManagerHelper.beginTransaction();
		u.addReponse(reponse);
		s.addReponse(reponse);
		this.manager.merge(u);
		this.manager.merge(s);
		EntityManagerHelper.commit();
		EntityManagerHelper.closeEntityManager();
		System.out.println("La r�ponse a �t� ajout�e!");
		return reponse;

	}

	public Collection<Utilisateur> getParticipantsByIdSondage(int idSondage) {
		Objects.requireNonNull(idSondage, "ne peut pas �tre null");
		try {
			Collection<ReponseSondage> reponses = this.reponses(idSondage);
			Collection<Utilisateur> participants = new ArrayList<Utilisateur>();

			for (ReponseSondage reponse : reponses) {
				participants.add(reponse.getParticipant());
			}
			return participants;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return null;
	}

	public Reunion getReunionByIdSondage(int idSondage) {
		Objects.requireNonNull(idSondage, "ne peut pas �tre null");
		try {
			return this.manager.createNamedQuery("finMeetingByIdSondage", Reunion.class)
			.setParameter("idSondage", idSondage).getSingleResult();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public Collection<ChoixDate> plages() {
		return this.manager.createNamedQuery("findAllChoixDate", ChoixDate.class).getResultList();
	}

	public void supprimerSondage(int idSondage) {
		Objects.requireNonNull(idSondage, "ne peut pas �tre null");
		try {
			Sondage sondage = manager.find(Sondage.class, idSondage);
			EntityManagerHelper.beginTransaction();
			this.manager.remove(sondage);
			EntityManagerHelper.commit();
			EntityManagerHelper.closeEntityManager();
			System.out.println("Le sondage a �t� bien supprim�");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public Sondage updateSondage(Sondage sondage) {
		Objects.requireNonNull(sondage, "ne peut pas �tre null");
		try {
			EntityManagerHelper.beginTransaction();
			this.manager.merge(sondage);
			EntityManagerHelper.commit();
			EntityManagerHelper.closeEntityManager();
			System.out.println("Le sondage a �t� bien modifi�");
			return sondage;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public ChoixDate getChoixDateById(int idChoixDate) {
		Objects.requireNonNull(idChoixDate, "ne peut pas �tre null");
		try {
			ChoixDate choixDate = manager.find(ChoixDate.class, idChoixDate);
			return choixDate;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	
	public Collection<ChoixDate> datesProposees(int idSondage) {
		Objects.requireNonNull(idSondage, "ne peut pas �tre null");
		try {
			Sondage sondage = manager.find(Sondage.class, idSondage);
			return sondage.getDates();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public ReponseSondage reponse(Reponse reponse) {
		Objects.requireNonNull(reponse, "ne peut pas �tre null");
		try {
			ReponseSondage rep = new ReponseSondage();
			int idSondage = reponse.getIdSondage();
			int idUtilisateur = reponse.getIdUtilisateur();
			Collection<ChoixDate> choixDonnes = reponse.getChoixDates();
			Sondage sondage = manager.find(Sondage.class, idSondage);
			Utilisateur utilisateur =  manager.find(Utilisateur.class, idUtilisateur);
			
			rep.setChoixDonnes(choixDonnes);
			rep.setParticipant(utilisateur);
			rep.setSondage(sondage);
			System.out.println("reponse adding");
			return this.repondreSondage(rep);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
