/**
 * 
 */
package daoImpl;

import java.util.Collection;
import java.util.Objects;

import javax.persistence.EntityManager;
import daoInterfaces.UtilisateurDAO;
import jpa.Alergies;
import jpa.ChoixDate;
import jpa.EntityManagerHelper;
import jpa.PreferenceAlimentaire;
import jpa.PreferenceId;
import jpa.ReponseSondage;
import jpa.Reunion;
import jpa.Role;
import jpa.Sondage;
import jpa.Utilisateur;

/**
 * @author Mahamadou SYLLA
 *
 */
public class UtilisateurDaoImpl implements UtilisateurDAO {
	private EntityManager manager;

	/**
	 *  
	 */
	public UtilisateurDaoImpl() {
		this.manager = EntityManagerHelper.getEntityManager();
	}

	public Utilisateur utilisateur(int userId) {
		Objects.requireNonNull(userId, "ne peut pas être null");
		try {
			Utilisateur user = manager.find(Utilisateur.class, userId);
			return user;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public Collection<Utilisateur> listUtilisateurs() {
		try {
			return this.manager.createNamedQuery("findAllUsers", Utilisateur.class).getResultList();
		} catch (Exception e) {
		}
		return null;
	}

	public Utilisateur creerUtilisateur(Utilisateur user) {
		Objects.requireNonNull(user, "ne peut pas être null");
		try {
			EntityManagerHelper.beginTransaction();
			this.manager.persist(user);
			EntityManagerHelper.commit();
			EntityManagerHelper.closeEntityManager();
			System.out.println("L'utilisateur a été bien enregistré");
			return user;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public Role ajouterRole(int userId, Role r) {
		Objects.requireNonNull(userId, "ne doit pas être nul");
		Objects.requireNonNull(r, "ne doit pas être nul");
		try {
			Utilisateur user = manager.find(Utilisateur.class, userId);
			EntityManagerHelper.beginTransaction();
			user.addRole(r);
			this.manager.persist(user);
			EntityManagerHelper.commit();
			EntityManagerHelper.closeEntityManager();
			System.out.println("Le rôle  : " + r.getName() + " a été bien enregistré");
			return r;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public Collection<Alergies> alergies(int userId) {
		Objects.requireNonNull(userId, "ne doit pas être nul");
		try {
			Utilisateur user = manager.find(Utilisateur.class, userId);
			return user.getAlergies();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public Collection<Reunion> reunionsAssistees(int userId) {
		Objects.requireNonNull(userId, "ne dois pas être nul");
		try {
			Utilisateur user = manager.find(Utilisateur.class, userId);
			return user.getPresences();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public Collection<Reunion> reunionsManquees(int userId) {
		Objects.requireNonNull(userId, "ne dois pas être nul");
		Utilisateur user = manager.find(Utilisateur.class, userId);
		try {
			return user.getAbsences();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public Collection<ReponseSondage> sondagesParticipes(int userId) {
		Objects.requireNonNull(userId, "ne dois pas être nul");
		try {
			Utilisateur user = manager.find(Utilisateur.class, userId);
			return user.getReponseSondages();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public Collection<PreferenceAlimentaire> preferencesAlimentaire(int idParticipant, int idReunion) {
		Objects.requireNonNull(idParticipant, "ne dois pas être nul");
		Objects.requireNonNull(idReunion, "ne dois pas être nul");
		try {
			Utilisateur user = manager.find(Utilisateur.class, idParticipant);
			Reunion meeting = manager.find(Reunion.class, idReunion);
			if (user != null && meeting != null) {
				return manager.createNamedQuery("findPreferencesByUserAndMeeting", PreferenceAlimentaire.class)
						.setParameter("idParticipant", idParticipant).setParameter("idReunion", idReunion)
						.getResultList();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;

	}

	public Collection<Sondage> sondagesCrees(int userId) {
		Objects.requireNonNull(userId, "ne dois pas être nul");
		Utilisateur user = manager.find(Utilisateur.class, userId);
		if (user != null) {
			return user.getSondages();
		} else {
			return null;
		}
	}

	public Collection<ChoixDate> reponseA_unSondage(int participantId, int sondageId) {
		Objects.requireNonNull(participantId, "ne dois pas être nul");
		Objects.requireNonNull(sondageId, "ne dois pas être nul");
		Utilisateur user = manager.find(Utilisateur.class, participantId);
		Sondage sondage = manager.find(Sondage.class, sondageId);

		if (user != null && sondage != null) {
			ReponseSondage r = (ReponseSondage) manager.createNamedQuery("findAnswersOfsurveyByUser")
					.setParameter("participantId", participantId).setParameter("sondageId", sondageId)
					.getSingleResult();
			return r.getChoixDonnes();
		} else {
			return null;
		}
	}

	//n'a pas été vérifiée
	public PreferenceAlimentaire ajouterPreference(int userId, int reunionId, PreferenceAlimentaire preferenceA) {
		Objects.requireNonNull(userId, "ne dois pas être nul");
		Objects.requireNonNull(reunionId, "ne dois pas être nul");
		Objects.requireNonNull(preferenceA, "ne dois pas être nul");
		try {
			Utilisateur user = manager.find(Utilisateur.class, userId);
			Reunion reunion = manager.find(Reunion.class, reunionId);
			if (user != null && reunion != null) {
				PreferenceId p = new PreferenceId(userId, reunionId);
				EntityManagerHelper.beginTransaction();
				preferenceA.setId(p);
				manager.persist(preferenceA);
				EntityManagerHelper.commit();
				EntityManagerHelper.closeEntityManager();
				System.out.println("La préference " + preferenceA.getPreference()
						+ " a été ajouté à aux préferences de " + user.getFirstName());
				return preferenceA;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;

	}

	public Collection<Role> roles(int userId) {
		Objects.requireNonNull(userId, "ne doit pas être nul");
		try {
			Utilisateur user = manager.find(Utilisateur.class, userId);
			return user.getRole();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public Utilisateur updateUtilisateur(Utilisateur user) {
		Objects.requireNonNull(user, "ne peut pas être null");
		try {
			EntityManagerHelper.beginTransaction();
			this.manager.merge(user);
			EntityManagerHelper.commit();
			EntityManagerHelper.closeEntityManager();
			System.out.println("L'utilisateur a été bien modifié");
			return user;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public void supprimerUtilisateur(int userId) {
		Objects.requireNonNull(userId, "ne peut pas être null");
		try {
			Utilisateur user = manager.find(Utilisateur.class, userId);
			EntityManagerHelper.beginTransaction();
			this.manager.remove(user);
			EntityManagerHelper.commit();
			EntityManagerHelper.closeEntityManager();
			System.out.println("L'utilisateur a été bien supprimé");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void supprimerRole(int roleId) {
		Objects.requireNonNull(roleId, "ne peut pas être null");
		try {
			Role role = manager.find(Role.class, roleId);
			EntityManagerHelper.beginTransaction();
			this.manager.remove(role);
			EntityManagerHelper.commit();
			EntityManagerHelper.closeEntityManager();
			System.out.println("Le rôle a été bien supprimé");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void updateRole(Role role) {
		Objects.requireNonNull(role, "ne peut pas être null");
		try {
			EntityManagerHelper.beginTransaction();
			this.manager.merge(role);
			EntityManagerHelper.commit();
			EntityManagerHelper.closeEntityManager();
			System.out.println("Le rôle a été bien modifié");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void ajouterAlergie(int userId, Alergies a) {
		Objects.requireNonNull(userId, "ne peut pas être null");
		try {
			Utilisateur user = manager.find(Utilisateur.class, userId);
			user.addAlergie(a);
			EntityManagerHelper.beginTransaction();
			this.manager.merge(user);
			EntityManagerHelper.commit();
			EntityManagerHelper.closeEntityManager();
			System.out.println("L'utilisateur a été bien modifié");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void updateAlergie(Alergies alergie) {
		Objects.requireNonNull(alergie, "ne peut pas être null");
		try {
			EntityManagerHelper.beginTransaction();
			this.manager.merge(alergie);
			EntityManagerHelper.commit();
			EntityManagerHelper.closeEntityManager();
			System.out.println("L'alergie a été bien modifiée");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void supprimerAlergie(int userId, int alergieId) {
		Objects.requireNonNull(userId, "ne peut pas être null");
		Objects.requireNonNull(alergieId, "ne peut pas être null");
		try {
			Utilisateur user = manager.find(Utilisateur.class, userId);
			Alergies alergie = manager.find(Alergies.class, alergieId);
			user.removeAlergie(alergie);
			EntityManagerHelper.beginTransaction();
			this.manager.merge(user);
			EntityManagerHelper.commit();
			EntityManagerHelper.closeEntityManager();
			System.out.println("Le rôle a été bien supprimé");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
