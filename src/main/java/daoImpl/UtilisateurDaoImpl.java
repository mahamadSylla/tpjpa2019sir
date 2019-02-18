/**
 * 
 */
package daoImpl;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.UtilisateurDAO;
import jpa.Alergies;
import jpa.EntityManagerHelper;
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
		String query ="SELECT u FROM Utilisateur u";
		Query q = manager.createQuery(query);
		return q.getResultList();

	}

	public Role role(long id) {
		return null;
	}

	public Collection<Sondage> sondagesCrees() {
		return null;
	}

	public Collection<Alergies> alergies(UtilisateurDAO utilisateur) {
		return null;
	}

	public Collection<Reunion> reunionsAssistees(UtilisateurDAO utilisateur) {
		return null;
	}

	public Collection<Sondage> sondagesParticipes(UtilisateurDAO utilisateur) {
		return null;
	}

	public Collection<String> preferencesAlimentaire(UtilisateurDAO utilisateur, Reunion reunion) {
		return null;
	}

	public Role role(UtilisateurDAO utilisateur) {
		return null;
	}

	public void ajouterRole(UtilisateurDAO utilisateur) {

	}

	public void createUtilisateur(Utilisateur user) {
		EntityManagerHelper.beginTransaction();
		this.manager.persist(user);
		EntityManagerHelper.commit();
		EntityManagerHelper.closeEntityManager();
		System.out.println("L'utilisateur a été bien enregistré"); 
		
	}

}
