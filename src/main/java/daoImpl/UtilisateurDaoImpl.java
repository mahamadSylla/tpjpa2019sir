/**
 * 
 */
package daoImpl;

import java.util.Collection;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import daoInterfaces.UtilisateurDAO;
import jpa.Alergies;
import jpa.ChoixDate;
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

	public void creerUtilisateur(Utilisateur user) {
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
		if(user != null) {
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
			return user.getPresences();
		}else {
			return null;
		}
	}
	
	public Collection<Reunion> reunionsManquees(int userId) {
		Objects.requireNonNull(userId, "ne dois pas être nul");
		Utilisateur user = manager.find(Utilisateur.class, userId);
		if(user != null) {
			return user.getAbsences();
		}else {
			return null;
		}
	}

	public Collection<ReponseSondage> sondagesParticipes1(int userId) {
		Objects.requireNonNull(userId, "ne dois pas être nul");
		Utilisateur user = manager.find(Utilisateur.class, userId);
		if(user != null) {
			return user.getReponseSondages();
		}else {
			return null;
		}
	}

	public Collection<Preference> preferencesAlimentaire(int userId, int idReunion) {
		Objects.requireNonNull(userId, "ne dois pas être nul");
		Objects.requireNonNull(idReunion, "ne dois pas être nul");
		Utilisateur user = manager.find(Utilisateur.class, userId);
		Reunion meeting = manager.find(Reunion.class, idReunion);
		if(user != null && meeting != null) {
			return manager.createNamedQuery("find_Preferences_User_meeting")
					.setParameter("userId", userId)
					.setParameter("reunionId", idReunion)
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

	public Collection<ChoixDate> reponseA_unSondage(int participantId, int sondageId) {
		Objects.requireNonNull(participantId, "ne dois pas être nul");
		Objects.requireNonNull(sondageId, "ne dois pas être nul");
		Utilisateur user = manager.find(Utilisateur.class, participantId);
		Sondage sondage = manager.find(Sondage.class, sondageId);
		
		if(user != null && sondage != null) {
			ReponseSondage r =  (ReponseSondage) manager.createNamedQuery("findAnswersOfsurveyByUser")
					.setParameter("participantId", participantId)
					.setParameter("sondageId", sondageId)
					.getSingleResult();
			return r.getChoixDonnes();
		}else {
			return null;
		} 
	}

	public Collection<ReponseSondage> sondagesParticipes(int userId) {
		return null;
	}

}
