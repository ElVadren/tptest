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
	 * 	définition de la méthode d'authentification de la partie Dao : requete adressée à mysql pour récupérer les données
	 */
	/**
	 * 	annotation du contexte de requête : définit dans le Persist Unit PU, géré par EJB
	 */
	@PersistenceContext(name="PU")
	/**
	 * 	Définition d'un entity manager
	 */
	EntityManager em;

	
	/**
	 * Méthode d'authentification de l'administrateur
	 */
	@Override
	public Admin isExistAdminDao(Admin ad) {

		/**
		 * 	requête écrite via jpql 
		 */

		String reqSql = "SELECT a FROM Admin a WHERE a.nomAdmin=:pNom and a.passwordAdmin=:pPassword";

		Query reqQuery = em.createQuery(reqSql);

		reqQuery.setParameter("pNom", ad.getNomAdmin());
		reqQuery.setParameter("pPassword", ad.getPasswordAdmin());

		System.out.println(ad.getNomAdmin());

		return ad;

	}

/**
 * Méthodes de gestion des produits
 */

	/**
	 * Ajout d'un produit à la table produit de la base de données tpeco
	 */
	@Override
	public Produit ajoutProduitDao(Produit a) {

		/**
		 * 	requête écrite via jpql 
		 */


		em.merge(a);

		System.out.println(a.getDescription());

		return a;

	}



	/**
	 * 	requête écrite via jpql : suppression d'un produit de la base de données
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
	 * 	requête écrite via jpql : modification d'un produit de la base de données
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
	 * Requête jpql pour rechercher un produit par id
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
		 * requête pour récupérer l'ensemble des produits de la base de données
		 */
		String sql = "SELECT p FROM Produit p";

		/**exécution de la requête*/
		Query query = em.createQuery(sql);

		/**
		 * récupération de la liste des résultats
		 */
		List<Produit> listeProduits = query.getResultList();
		/** 
		 * test pour vérifier que la liste n'est pas nulle
		 */
		if(listeProduits.size()!=0){
			return listeProduits;
		}else{
			System.out.println("la liste est vide");
			return null;
		}
		
	}

	
	
	/**
	 * Méthode de gestion des catégories
	 */


	/**
	 * Ajout d'une catégorie à la table catégorie de la base de données tpeco
	 */
	@Override
	public Categorie ajoutCategorieDao(Categorie c) {

		/**
		 * 	requête écrite via jpql 
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
		 * requête pour récupérer l'ensemble des catégories de la base de données
		 */
		String sql = "SELECT p FROM Categorie p";

		/**exécution de la requête*/
		Query query = em.createQuery(sql);

		/**
		 * récupération de la liste des résultats
		 */
		List<Categorie> listeCategories = query.getResultList();
		/** 
		 * test pour vérifier que la liste n'est pas nulle
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
