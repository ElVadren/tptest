package fr.adaming.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.entities.Admin;
import sun.management.Agent;

public class AdminDaoImpl implements IAdminDao {

//	d�finition de la m�thode d'authentification de la partie Dao : requete adress�e � mysql pour r�cup�rer les donn�es
//	annotation du contexte de requ�te : d�finit dans le Persist Unit PU, g�r� par EJB
	@PersistenceContext(name="PU")
//	D�finition d'un entity manager
	EntityManager em;
	
	@Override
	public Admin isExistAdminDao(Admin ad) {
		
//		requ�te sql 
		String reqSql = "SELECT * FROM admin a where a.nom = p:nom_admin and a.password = p:password_admin ";
		
		Query reqQuery = em.createQuery(reqSql);
		
		reqQuery.setParameter("pNom", ad.getNomAdmin());
		reqQuery.setParameter("pPassword", ad.getPasswordAdmin());

		return ad;
		
	}
	
}
