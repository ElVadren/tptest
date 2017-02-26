package fr.adaming.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.entities.Admin;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;
import sun.management.Agent;

@Stateless
public class AdminDaoImpl implements IAdminDao {

	/**
	 * 	d�finition de la m�thode d'authentification de la partie Dao : requete adress�e � mysql pour r�cup�rer les donn�es
	 */
	/**
	 * 	annotation du contexte de requ�te : d�finit dans le Persist Unit PU, g�r� par EJB
	 */
	@PersistenceContext(name="PU")
	/**
	 * 	D�finition d'un entity manager
	 */
	EntityManager em;

	
	/**
	 * M�thode d'authentification de l'administrateur
	 */
	@Override
	public Admin isExistAdminDao(Admin ad) {

		/**
		 * 	requ�te �crite via jpql 
		 */

		String reqSql = "SELECT a FROM Admin a WHERE a.nomAdmin=:pNom and a.passwordAdmin=:pPassword";

		Query reqQuery = em.createQuery(reqSql);

		reqQuery.setParameter("pNom", ad.getNomAdmin());
		reqQuery.setParameter("pPassword", ad.getPasswordAdmin());

		System.out.println(ad.getNomAdmin());

		return ad;

	}

/**
 * M�thodes de gestion des produits
 */

	/**
	 * Ajout d'un produit � la table produit de la base de donn�es tpeco
	 */
	@Override
	public Produit ajoutProduitDao(Produit a) {

		/**
		 * 	requ�te �crite via jpql 
		 */


		em.merge(a);

		System.out.println(a.getDescription());

		return a;

	}



	/**
	 * 	requ�te �crite via jpql : suppression d'un produit de la base de donn�es
	 */
	@Override
	public Produit supprimerProduitDao(long id) {

		String reqSql = "delete from Produit a where a.idProduit=:pIdProduit";

		Query reqQuery = em.createQuery(reqSql);

		reqQuery.setParameter("pIdProduit", id);

		System.out.println("test"+ id);
		
		int deleted = reqQuery.executeUpdate ();

		return null;

	}


	/**
	 * 	requ�te �crite via jpql : modification d'un produit de la base de donn�es
	 */
	@Override
	public Produit modifierProduitDao(long id, String description, String designation, double prix) {

		String reqSql = "update Produit p set p.description=:descriptionProduit, p.designation=:designationProduit,p.prix=:prixProduit  where p.idProduit =:idProduit";

		Query reqQuery = em.createQuery(reqSql);

		reqQuery.setParameter("descriptionProduit", description);
		reqQuery.setParameter("designationProduit", designation);
		reqQuery.setParameter("prixProduit", prix);
		reqQuery.setParameter("idProduit", id);
		
		Produit produit = new Produit(id, description, designation, prix);
		System.out.println(produit);
		
		int updated = reqQuery.executeUpdate();
		
		if (produit!=null){
			return produit;
		}else{
			return null;
		}
	}


	/**
	 * Requ�te jpql pour rechercher un produit par id
	 */

	@Override
	public Produit rechercherProduitParIdDao(long id) {

		String sql = "SELECT p FROM Produit p WHERE p.idProduit=:idProduit ";

		Query query = em.createQuery(sql);
		query.setParameter("idProduit", id);

		Produit produit = (Produit) query.getSingleResult();
		if (produit!=null){
			return produit;
		}else{
			return null;
		}
	}


	@Override
	public List<Produit> getAllProduitDao() {

		/**
		 * requ�te pour r�cup�rer l'ensemble des produits de la base de donn�es
		 */
		String sql = "SELECT p FROM Produit p";

		/**ex�cution de la requ�te*/
		Query query = em.createQuery(sql);

		/**
		 * r�cup�ration de la liste des r�sultats
		 */
		List<Produit> listeProduits = query.getResultList();
		/** 
		 * test pour v�rifier que la liste n'est pas nulle
		 */
		if(listeProduits.size()!=0){
			return listeProduits;
		}else{
			System.out.println("la liste est vide");
			return null;
		}
		
	}

	
	
	/**
	 * M�thode de gestion des cat�gories
	 */


	/**
	 * Ajout d'une cat�gorie � la table cat�gorie de la base de donn�es tpeco
	 */
	@Override
	public Categorie ajoutCategorieDao(Categorie c) {

		/**
		 * 	requ�te �crite via jpql 
		 */


		em.persist(c);

		System.out.println(c.getNomCategorie());

		return c;

	}

	@Override
	public Categorie supprimerCategorieDao(long idCategorie) {
		String reqSql = "delete from Categorie a where a.idCategorie=:pIdCategorie";

		Query reqQuery = em.createQuery(reqSql);

		reqQuery.setParameter("pIdCategorie", idCategorie);

		System.out.println("test"+ idCategorie);
		
		int deleted = reqQuery.executeUpdate ();
		
		return null;
	}

	@Override
	public Categorie modifierCategorieDao(long idCategorie, String description, String nomCategorie) {

		String reqSql = "update Categorie p set p.nomCategorie=:nomCategorie, p.description=:description  where p.idCategorie=:idCategorie";

		Query reqQuery = em.createQuery(reqSql);

		reqQuery.setParameter("nomCategorie", nomCategorie);
		reqQuery.setParameter("description", description);
		reqQuery.setParameter("idCategorie", idCategorie);
		
		Categorie categorie = new Categorie(idCategorie, nomCategorie, description);
		System.out.println(categorie);
		
		int updated = reqQuery.executeUpdate();
		
		if (categorie!=null){
			return categorie;
		}else{
			return null;
		}
	}

	@Override
	public List<Categorie> getAllCategorieDao() {
		/**
		 * requ�te pour r�cup�rer l'ensemble des cat�gories de la base de donn�es
		 */
		String sql = "SELECT p FROM Categorie p";

		/**ex�cution de la requ�te*/
		Query query = em.createQuery(sql);

		/**
		 * r�cup�ration de la liste des r�sultats
		 */
		List<Categorie> listeCategories = query.getResultList();
		/** 
		 * test pour v�rifier que la liste n'est pas nulle
		 */
		if(listeCategories.size()!=0){
			return listeCategories;
		}else{
			System.out.println("la liste est vide");
			return null;
		}
		
	}

	@Override
	public Categorie rechercherCategorieParIdDao(long idCategorie) {
	
		String sql = "SELECT p FROM Categorie p WHERE p.idCategorie=:idCategorie ";

		Query query = em.createQuery(sql);
		query.setParameter("idCategorie", idCategorie);

		Categorie categorie = (Categorie) query.getSingleResult();
		if (categorie!=null){
			return categorie;
		}else{
			return null;
		}
	}

	@Override
	public Object attribuerDao(long idProduit, long idCategorie) {

		String reqSql = "update Produit p set p.categorie=:categorie where p.idProduit=:idProduit";
		
		Categorie categorie = new Categorie();
		categorie.setIdCategorie(idCategorie);
		
		Query reqQuery = em.createQuery(reqSql);
		
		reqQuery.setParameter("categorie", categorie);
		reqQuery.setParameter("idProduit", idProduit);
		
		int updated = reqQuery.executeUpdate();
		
		return null;
		
	}
	
	
	
}
