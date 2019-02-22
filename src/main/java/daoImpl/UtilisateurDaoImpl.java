/**
 * 
 */
package daoImpl;

import java.util.Collection;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.UtilisateurDAO;
import jpa.Alergies;
import jpa.EntityManagerHelper;
import jpa.Preference;
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

	public Collection<Utilisateur> listUtilisateurs() {
		String query = "SELECT u FROM Utilisateur u";
		Query q = manager.createQuery(query);
		return q.getResultList();

	}

	public void createUtilisateur(Utilisateur user) {
		EntityManagerHelper.beginTransaction();
		this.manager.persist(user);
		EntityManagerHelper.commit();
		EntityManagerHelper.closeEntityManager();
		System.out.println("L'utilisateur a été bien enregistré");

	}

	public void ajouterRole(int userId, Role r) {
		Objects.requireNonNull(userId, "ne doit pas être nul");
		Objects.requireNonNull(r, "ne doit pas être nul");
		Utilisateur user = manager.find(Utilisateur.class, userId);
		Role role = manager.find(Role.class, r);
		if(user != null && role != null) {
			EntityManagerHelper.beginTransaction();
			user.addRole(r);
			this.manager.persist(user);
			EntityManagerHelper.commit();
			EntityManagerHelper.closeEntityManager();
			System.out.println("Le rôle  : "+ r.getName()+" a été bien enregistré");
		}else {
			System.out.println("Cet utilisateur ou ce rôle n'existe pas!");
		}
		
	}

	public Collection<Alergies> alergies(int userId) {
		Objects.requireNonNull(userId, "ne doit pas être nul");
		Utilisateur user = manager.find(Utilisateur.class, userId);
		if(user != null) {
			return user.getAlergies();
		}else {
			return null;
		}
	}

	public Collection<Reunion> reunionsAssistees(int userId) {
		Objects.requireNonNull(userId, "ne dois pas être nul");
		Utilisateur user = manager.find(Utilisateur.class, userId);
		if(user != null) {
			return user.getReunions();
		}else {
			return null;
		}
	}

	/*public Collection<ReponseSondage> sondagesParticipes(int userId) {
		Objects.requireNonNull(userId, "ne dois pas être nul");
		Utilisateur user = manager.find(Utilisateur.class, userId);
		if(user != null) {
			return user.getReponseSondages();
		}else {
			return null;
		}
	}
*/
	public Collection<Preference> preferencesAlimentaire(int userId, int meetingId) {
		Objects.requireNonNull(userId, "ne dois pas être nul");
		Objects.requireNonNull(meetingId, "ne dois pas être nul");
		Utilisateur user = manager.find(Utilisateur.class, userId);
		Reunion meeting = manager.find(Reunion.class, meetingId);
		if(user != null && meeting != null) {
			return manager.createNamedQuery("find_Preferences_User_meeting")
					.setParameter("userId", userId)
					.setParameter("reunionId", meetingId)
					.getResultList();
		}else {
			return null;
		}
	}

	public Collection<Sondage> sondagesCrees(int userId) {
		Objects.requireNonNull(userId, "ne dois pas être nul");
		Utilisateur user = manager.find(Utilisateur.class, userId);
		if(user != null) {
			return user.getSondages();
		}else {
			return null;
		}
	}

	public Collection<ReponseSondage> reponseA_unSondage(int userId, int surveyId) {
		Objects.requireNonNull(userId, "ne dois pas être nul");
		Objects.requireNonNull(surveyId, "ne dois pas être nul");
		Utilisateur user = manager.find(Utilisateur.class, userId);
		Sondage sondage = manager.find(Sondage.class, surveyId);
		if(user != null && sondage != null) {
			return manager.createNamedQuery("find_Answers_User_survey")
					.setParameter("userId", userId)
					.setParameter("sondageId", surveyId)
					.getResultList();
		}else {
			return null;
		}
	}

	public Collection<ReponseSondage> sondagesParticipes(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
