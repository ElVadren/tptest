package fr.adaming.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.entities.Admin;
import sun.management.Agent;

public class AdminDaoImpl implements IAdminDao {

//	définition de la méthode d'authentification de la partie Dao : requete adressée à mysql pour récupérer les données
//	annotation du contexte de requête : définit dans le Persist Unit PU, géré par EJB
	@PersistenceContext(name="PU")
//	Définition d'un entity manager
	EntityManager em;
	
	@Override
	public Admin isExistAdminDao(Admin ad) {
		
//		requête sql 
		String reqSql = "SELECT * FROM admin a where a.nom = p:nom_admin and a.password = p:password_admin ";
		
		Query reqQuery = em.createQuery(reqSql);
		
		reqQuery.setParameter("pNom", ad.getNomAdmin());
		reqQuery.setParameter("pPassword", ad.getPasswordAdmin());

		return ad;
		
	}
	
}
