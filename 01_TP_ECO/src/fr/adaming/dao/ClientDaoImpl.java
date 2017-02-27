package fr.adaming.dao;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.entities.Admin;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Client;
import fr.adaming.entities.Commande;
import fr.adaming.entities.LigneCommande;
import fr.adaming.entities.Panier;
import fr.adaming.entities.Produit;

@Stateless
public class ClientDaoImpl implements IClientDao {

/**
 * appel de l'entity manager pour la connexion avec la bdd.
 */
	@PersistenceContext(unitName="PU")
	EntityManager em;
	
	
	/**
	 * la méthode pour obtenir la liste des catégories
	 */
	@Override
	public List<Categorie> getAllCategorie() {
		
		/**
		 * écriture de la requête :
		 */
		String req = "select c from Categorie c";
		Query query = em.createQuery(req);
		/**
		 * récupération de la liste
		 */
		List<Categorie> listeCategorie = query.getResultList();
		/**
		 * condition pour vérifier si la liste n'est pas vide :
		 */
		if(listeCategorie.size()!=0){
			return listeCategorie;
		}else{
		System.out.println("la liste est vide");
		return null;
		}
	}

	/**
	 * La méthode pour obtenir la liste des produits par catégorie :
	 */
	@Override
	public List<Produit> getProduitsByCategorie(Categorie categorie) {
	
	
	
		/**
		 * écriture de la requête
		 */
		String req = "select p from Produit p where p.categorie.idCategorie=:idCategorie";
		/**
		 * Insertion dans une query et remplacement du pseudo par l'id de la catégorie choisie
		 */
		Query query = em.createQuery(req);
		query.setParameter("idCategorie", categorie.getIdCategorie());
		/**
		 * Récupération des résultats dans une liste et transmission
		 */
		List<Produit> listeProduitCat = query.getResultList();
		if(listeProduitCat.size()!=0){
		return listeProduitCat;
		}else{
		return null;
		}
	}

	/**
	 * La methode pour obtenir une liste de produit via un mot clé 
	 * Version 1 : recherche uniquement dans la designation !!
	 * 
	 * 
	 */
	@Override
	public List<Produit> getProduitsByMot(String saisie) {
		
		
		String req = "select p from Produit p where p.designation like '%"+saisie+"%'";
		Query query = em.createQuery(req);
		List<Produit> listeProduitKey = query.getResultList();
		if(listeProduitKey.size()!=0){
			return listeProduitKey;
			}else{
			return null;
	}

}
	
	/**
	 * méthode pour obtenir un produit via son id
	 */
	@Override
	public Produit getProduitById(long id) {
		String req = "select p from Produit p where p.idProduit=:idPseudo";
		Query query = em.createQuery(req);
		query.setParameter("idPseudo", id);
		Produit produit = (Produit) query.getSingleResult();
		if (produit!=null){
			return produit;
		}else{
		return null;
		}
	}

	/**
	 * methode pour enregistrer un nouveau client dans la bdd
	 */
	@Override
	public void enregistrementClient(Client client) {
		em.persist(client);	
	}

	/**
	 * La méthode débute par la création d'une nouvelle commande :
	 * On lui attribut le client ainsi que la date
	 * Il faut ensuite enregistrer la commande dans la base de donnée.
	 * Par persistence, toutes les informations (panier/ligne de commande) sont enregistrée et liée en même temps
	 */
	@Override
	public void enregistrementCommande(Client client, List<Produit> listeProduit) {
		Commande commande = new Commande ();
		commande.setClient(client);
		Panier panier = new Panier ();
		List<LigneCommande> listeC = new ArrayList<LigneCommande>();
		for (Produit p:listeProduit){
			LigneCommande produitc = new LigneCommande();
			produitc.setDesignation(p.getDesignation());
			produitc.setDescription(p.getDescription());
			produitc.setQuantite(p.getQuantite());
			produitc.setPrix(p.getPrix());
			produitc.setPanier(panier);
			listeC.add(produitc);
		}
		panier.setListProduit(listeC);
	
		Date date = new Date();
		System.out.println(date);
		commande.setDateCommande(date);
		commande.setPanier(panier);
	
		em.persist(commande);
	}
	

	/**
	 * Cette méthode permet de récupérer la liste de tout les produits pour l'afficher sur la page d'accueil
	 */
	@Override
	public List<Produit> getAllProduits() {
		/**
		 * écriture de la requête :
		 */
		String req = "select p from Produit p";
		Query query = em.createQuery(req);
		/**
		 * récupération de la liste
		 */
		List<Produit> listeProduit = query.getResultList();
		/**
		 * condition pour vérifier si la liste n'est pas vide :
		 */
		if(listeProduit.size()!=0){
			return listeProduit;
		}else{
		return null;
		}
	}

	/**
	 * Cette méthode est utilisée pour reconnaitre un ancien client d'un nouveau client à l'aide ses identifiantss
	 */
	@Override
	public Client isExist(Client client) {
		/**
		 * 	requête écrite via jpql 
		 */

		String reqSql = "SELECT c FROM Client c WHERE c.nomClient=:pNom and c.email=:pMail";

		Query reqQuery = em.createQuery(reqSql);

		reqQuery.setParameter("pNom", client.getNomClient());
		reqQuery.setParameter("pMail", client.getEmail());

		try{
			Client clientr = (Client) reqQuery.getSingleResult();
			
			if (clientr!=null) {
				return clientr;
			} else {
				return null;
			}
		}catch(NoResultException e){
			return null;
		}
		
		
	}

	/**
	 * Cette méthode permet de récupérer toutes commandes d'un client, pour que celui-ci puisse les consulter 
	 * dans son espace personnel
	 */
	@Override
	public List<Commande> getCommandeByClient(Client client) {
		/**
		 * écriture de la requête
		 */
		String req = "select c from Commande c where c.client.idClient=:idClient";
		/**
		 * Insertion dans une query et remplacement du pseudo par l'id de la catégorie choisie
		 */
		Query query = em.createQuery(req);
		query.setParameter("idClient", client.getIdClient());
		/**
		 * Récupération des résultats dans une liste et transmission
		 */
		List<Commande> listeCommande = query.getResultList();
		if(listeCommande.size()!=0){
		return listeCommande;
		}else{
		return null;
		}
	}

	/**
	 * Cette méthode permet à un client connecté de consulter les anciens panier qu'il a commandé 
	 */
	public List<LigneCommande> getPanierByCommande(Commande commande) {
		/**
		 * Ecriture de la requête : tous les produits commandés correspondant au panier 
		 * de la commande sont extraits de la base.
		 * Comme à chaque panier correspond une commande dans la bdd et que une commande et un panier sont créer 
		 * en même temps, l'ID du panier = ID de la commande.
		 * 
		 */
		String req = "select l from LigneCommande l where l.panier.id=:idPanier";
		Query query = em.createQuery(req);
		query.setParameter("idPanier", commande.getIdCommande());
		List<LigneCommande> listeProduitCo = query.getResultList();
		if (listeProduitCo.size()>0){
		return listeProduitCo;
		}else{
			return null;
		}
	}

	

	


	
}