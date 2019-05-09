package daoImpl;

import java.util.Collection;
import java.util.Objects;

import javax.persistence.EntityManager;
import daoInterfaces.ReunionDAO;
import jpa.EntityManagerHelper;
import jpa.PreferenceAlimentaire;
import jpa.Reunion;
import jpa.Sondage;
import jpa.Utilisateur;

public class ReunionDaoImpl implements ReunionDAO {
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
			return manager.find(Reunion.class, idReunion);
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

	public Collection<Reunion> listReunion() {
		try {
			return this.manager.createNamedQuery("findAllMeeting", Reunion.class).getResultList();
		} catch (Exception e) {
		}
		return null;
	}

	public Reunion creerReunion(int idSondage, Reunion reunion) {
		Objects.requireNonNull(reunion, "ne peut pas être null");
		Objects.requireNonNull(idSondage, "ne peut pas être null");
		Sondage sondage = manager.find(Sondage.class, idSondage);
		reunion.setSondage(sondage);
		reunion.setDateReunion(sondage.getDateRetenue());
		EntityManagerHelper.beginTransaction();
		this.manager.persist(reunion);
		EntityManagerHelper.commit();
		EntityManagerHelper.closeEntityManager();
		System.out.println("La reunion a été créée!");
		return reunion;
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

	public Collection<PreferenceAlimentaire> preferencesAlimentaire(int idReunion) {
		Objects.requireNonNull(idReunion, "ne dois pas être nul");
		Reunion meeting = manager.find(Reunion.class, idReunion);
		if (meeting != null) {
			return manager.createNamedQuery("findPreferencesByMeeting", PreferenceAlimentaire.class)
					.setParameter("idReunion", idReunion).getResultList();
		} else {
			return null;
		}
	}

	public void supprimerReunion(int idReunion) {
		Objects.requireNonNull(idReunion, "ne peut pas être null");
		try {
			Reunion reunion = manager.find(Reunion.class, idReunion);
			EntityManagerHelper.beginTransaction();
			this.manager.remove(reunion);
			EntityManagerHelper.commit();
			EntityManagerHelper.closeEntityManager();
			System.out.println("La réunion a été bien supprimée");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public Reunion updateReunion(Reunion reunion) {
		Objects.requireNonNull(reunion, "ne peut pas être null");
		try {
			EntityManagerHelper.beginTransaction();
			this.manager.merge(reunion);
			EntityManagerHelper.commit();
			EntityManagerHelper.closeEntityManager();
			System.out.println("La réunion a été bien modifiée");
			return reunion;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

}
